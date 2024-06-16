package weather.analyzer;

import java.io.UnsupportedEncodingException;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;

public class WeatherSerializer implements Serializer<WeatherItem> {
  @Override
  public byte[] serialize(String topic, WeatherItem data) {
    if (data == null) {
      return null;
    }

    try {
      return new Gson().toJson(data).getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return null;
  }
}
