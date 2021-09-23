package configuration;

import configuration.DefaultConfigurator;
import message.Message;
import org.junit.jupiter.api.Test;
import tools.SensorModel;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class DefaultConfiguratorTest {
    DefaultConfigurator defaultConfigurator = new DefaultConfigurator();

    @Test
    void testConfigurePayloadShouldReturnPayloadMessage() {
        Message message = new Message("SensorID_1", "WS-0001", "  tPM    ");
        String testExpectedResult = "  tPM    ";


        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void testConfigurePayloadShouldReturnPayloadMessagePad() {
        Message message = new Message("SensorID_1", "WS-0002", "  tPM    ");
        String testExpectedResult = "##tPM#####";

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void testConfigurePayloadShouldReturnPayloadMessageTrimPad() {
        Message message = new Message("SensorID_1", "WS-0003", "  tPM    ");
        String testExpectedResult = "tPM#######";

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void testConfigurePayloadShouldReturnPayloadMessageTrimPadAddTimeStamp() {
        Message message = new Message("SensorID_1", "WS-0004", "  tPM    ");

        Long timeStamp = Instant.now().getEpochSecond();
        String testExpectedResult = "tPM#######_" + timeStamp;

        assertEquals(testExpectedResult, defaultConfigurator.configurePayload(message));
    }

    @Test
    void testConfigureOutputShouldThrowISExceptionIfModelUnknown() {
        Message message = new Message("SensorID_1", "unknownModel", "  tPM    ");

        assertThrows(IllegalArgumentException.class, () -> defaultConfigurator.configureOutput(message));
    }

    @Test
    void testIdentifyModelShouldReturnEnumSensorModel() {
        Message message = new Message("SensorID_1", "WS-0004", "  tPM    ");
        SensorModel testExpectedResult = SensorModel.WS_0004;

        assertEquals(testExpectedResult, defaultConfigurator.identifyModel(message));
    }
}