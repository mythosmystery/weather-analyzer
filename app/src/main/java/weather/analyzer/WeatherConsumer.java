package weather.analyzer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class WeatherConsumer extends Thread {
  public void run() {
    Properties properties = new Properties();
    try {
      properties.load(WeatherConsumer.class.getResourceAsStream("/kafka.properties"));
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    KafkaConsumer<String, WeatherItem> consumer = new KafkaConsumer<>(properties);
    consumer.subscribe(Collections.singletonList("weather-data"));

    try {
      while (true) {
        ConsumerRecords<String, WeatherItem> records = consumer.poll(Duration.ofMillis(10));
        for (ConsumerRecord<String, WeatherItem> record : records) {
          System.out.printf("Consumed: key = %s, value = %s, partition = %d, offset = %d%n",
              record.key(), record.value(), record.partition(), record.offset());
        }
      }
    } finally {
      consumer.close();
    }
  }
}
