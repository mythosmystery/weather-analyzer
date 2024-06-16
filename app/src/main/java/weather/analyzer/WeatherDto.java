package weather.analyzer;

public class WeatherDto {
  public class Hourly {
    private String[] time;

    private float[] temperature_2m;

    private float[] apparent_temperature;

    private float[] rain;

    private float[] snowfall;

    public String[] getTime() {
      return time;
    }

    public void setTime(String[] time) {
      this.time = time;
    }

    public float[] getTemperature_2m() {
      return temperature_2m;
    }

    public void setTemperature_2m(float[] temperature_2m) {
      this.temperature_2m = temperature_2m;
    }

    public float[] getApparent_temperature() {
      return apparent_temperature;
    }

    public void setApparent_temperature(float[] apparent_temperature) {
      this.apparent_temperature = apparent_temperature;
    }

    public float[] getRain() {
      return rain;
    }

    public void setRain(float[] rain) {
      this.rain = rain;
    }

    public float[] getSnowfall() {
      return snowfall;
    }

    public void setSnowfall(float[] snowfall) {
      this.snowfall = snowfall;
    }
  };

  private float latitude;

  private float longitude;

  private String timezone;

  private Hourly hourly;

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public Hourly getHourly() {
    return hourly;
  }

  public void setHourly(Hourly hourly) {
    this.hourly = hourly;
  }
}
