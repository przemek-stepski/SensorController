import configuration.DefaultConfigurator;
import message.Message;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class DefaultConfiguratorTest {

    @Test
    void testConfigurePayloadShouldReturnPayloadMessage() {
        Message message = new Message("SensorID_1", "WS-0001", "  tPM    ");
        String testExpectedResult = "  tPM    ";

        DefaultConfigurator defaultConfigurator = new DefaultConfigurator();

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void testConfigurePayloadShouldReturnPayloadMessagePad() {
        Message message = new Message("SensorID_1", "WS-0002", "  tPM    ");
        String testExpectedResult = "##tPM#####";

        DefaultConfigurator defaultConfigurator = new DefaultConfigurator();

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }
    @Test
    void testConfigurePayloadShouldReturnPayloadMessageTrimPad() {
        Message message = new Message("SensorID_1", "WS-0003", "  tPM    ");
        String testExpectedResult = "tPM#######";

        DefaultConfigurator defaultConfigurator = new DefaultConfigurator();

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void testConfigurePayloadShouldReturnPayloadMessageTrimPadAddTimeStamp() {
        Message message = new Message("SensorID_1", "WS-0004", "  tPM    ");

        Long timeStamp = Instant.now().getEpochSecond();
        String testExpectedResult = "tPM#######_" + timeStamp;

        DefaultConfigurator defaultConfigurator = new DefaultConfigurator();

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void configureOutput() {
    }

    @Test
    void identifyModel() {
    }
}