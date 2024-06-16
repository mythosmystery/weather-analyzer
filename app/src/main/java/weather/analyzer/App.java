package weather.analyzer;

public class App {
  public static void main(String[] args) {
    WeatherProducer producerThread = new WeatherProducer();
    WeatherConsumer consumerThread = new WeatherConsumer();

    producerThread.start();
    consumerThread.start();

    try {
      producerThread.join();
      consumerThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
