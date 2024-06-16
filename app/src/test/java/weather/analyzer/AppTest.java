/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package weather.analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  void appHasAGreeting() {
    Thread producerThread = new WeatherProducer();
    Thread consumerThread = new WeatherConsumer();
    assertNotNull(producerThread, "producerThread should not be null");
    assertNotNull(consumerThread, "consumerThread should not be null");
  }
}
