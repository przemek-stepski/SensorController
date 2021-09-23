package configuration;

import java.time.Instant;
import message.Message;
import tools.*;

public class DefaultConfigurator implements Configurator {

    public String configurePayload(Message message) {
        Handler handler = new Handler();

        switch (identifyModel(message)) {
            case WS_0001: {
                return message.getPayload();
            }
            case WS_0002: {
                return handler.padToMultiple(message.getPayload());
            }
            case WS_0003: {
                return handler.padToMultiple(handler.trim(message.getPayload()));
            }
            case WS_0004: {
                return handler.addTimestamp(handler.padToMultiple(handler.trim(message.getPayload())));
            }
            default:
                throw new IllegalStateException("Unexpected value of model in message: " + identifyModel(message));
        }
    }

    public void configureOutput(Message message) {
        Output output = new Output();

        switch (identifyModel(message)) {
            case WS_0001:
            case WS_0002: {
                output.consoleOutput(message);
                break;
            }
            case WS_0003: {
                output.fileOutput(message, "messageFrom" + message.getSensor_id() + " " + Instant.now() + ".json");
                break;
            }
            case WS_0004: {
                output.fileOutput(message, "messageFrom" + message.getSensor_id() + " " + Instant.now() + ".json");
                output.consoleOutput(message);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value of model in message: " + identifyModel(message));
        }
    }

    public SensorModel identifyModel(Message message) {
        String model = message.getModel().trim().toUpperCase().replace("-", "_");
        return SensorModel.valueOf(model);
    }
}
