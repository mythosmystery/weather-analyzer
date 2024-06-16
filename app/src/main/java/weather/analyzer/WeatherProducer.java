package weather.analyzer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Properties;

public class WeatherProducer extends Thread {
  public void run() {
    Properties properties = new Properties();
    try {
      properties.load(WeatherProducer.class.getResourceAsStream("/kafka.properties"));
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    Producer<String, WeatherItem> producer = new KafkaProducer<>(properties);

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet request = new HttpGet(
          "https://archive-api.open-meteo.com/v1/archive?latitude=33&longitude=-113&start_date=2024-01-01&end_date=2024-06-01&hourly=temperature_2m,apparent_temperature,rain,snowfall&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch");
      HttpResponse response = httpClient.execute(request);
      Gson gson = new Gson();

      WeatherDto data = gson.fromJson(EntityUtils.toString(response.getEntity()), WeatherDto.class);

      for (int i = 0; i < data.getHourly().getTemperature_2m().length; i++) {
        WeatherItem item = new WeatherItem(data.getHourly().getTime()[i], data.getHourly().getTemperature_2m()[i],
            data.getHourly().getApparent_temperature()[i], data.getHourly().getRain()[i],
            data.getHourly().getSnowfall()[i]);

        ProducerRecord<String, WeatherItem> record = new ProducerRecord<>("weather-data", item);
        producer.send(record);
        System.out.printf("Produced: key = %s, value = %s%n", record.key(), record.value());
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    producer.close();
  }
}
