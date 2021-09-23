package configuration;

import message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifiedConfiguratorTest {

    ModifiedConfigurator modifiedConfigurator = new ModifiedConfigurator();
    Message message = new Message("SensorID_1", "WS-0004", "  tPM    ");


    @Test
    void testConfigurePayloadShouldReturnOriginalMessageIfIncorrectHandler() {
        String incorrectHandler = "incorrectHandler";

        assertEquals(message.getPayload(), modifiedConfigurator.configurePayload(message, incorrectHandler));
    }

}