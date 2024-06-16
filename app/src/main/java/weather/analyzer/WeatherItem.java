package weather.analyzer;

public class WeatherItem {
  private String time;
  private float temperature_2m;
  private float apparent_temperature;
  private float rain;
  private float snowfall;

  WeatherItem(String time, float temperature_2m, float apparent_temperature, float rain, float snowfall) {
    this.time = time;
    this.temperature_2m = temperature_2m;
    this.apparent_temperature = apparent_temperature;
    this.rain = rain;
    this.snowfall = snowfall;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public float getTemperature_2m() {
    return temperature_2m;
  }

  public void setTemperature_2m(float temperature_2m) {
    this.temperature_2m = temperature_2m;
  }

  public float getApparent_temperature() {
    return apparent_temperature;
  }

  public void setApparent_temperature(float apparent_temperature) {
    this.apparent_temperature = apparent_temperature;
  }

  public float getRain() {
    return rain;
  }

  public void setRain(float rain) {
    this.rain = rain;
  }

  public float getSnowfall() {
    return snowfall;
  }

  public void setSnowfall(float snowfall) {
    this.snowfall = snowfall;
  }
}
