package configuration;

import message.Message;
import tools.Handler;
import tools.Output;

public class ModifiedConfigurator implements Configurator {

    public void configureOutput(Message message, String pathToSavedFile) {
        Output output = new Output();

        output.fileOutput(message, pathToSavedFile);
    }

    public String configurePayload(Message message, String handlerToUse) {
        Handler handler = new Handler();
        String currentMessage = null;

        switch (handlerToUse) {
            case "trim":
                currentMessage = handler.trim(message.getPayload());
                break;
            case "add":
                currentMessage = handler.addTimestamp(message.getPayload());
                break;
            case "pad":
                currentMessage = handler.padToMultiple(message.getPayload());
                break;
            default:
                System.out.println("You have typed incorrect handler");
        }
        return currentMessage;
    }
}

