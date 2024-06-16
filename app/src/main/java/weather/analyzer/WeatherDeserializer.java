package weather.analyzer;

import java.io.UnsupportedEncodingException;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;

public class WeatherDeserializer implements Deserializer<WeatherItem> {
  @Override
  public WeatherItem deserialize(String topic, byte[] data) {
    if (data == null) {
      return null;
    }

    try {
      return new Gson().fromJson(new String(data, "UTF-8"), WeatherItem.class);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return null;
  }
}
