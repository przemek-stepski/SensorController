package message;

import configuration.DefaultConfigurator;
import configuration.ModifiedConfigurator;

public class MessageManager {

    DefaultConfigurator defaultConfigurator = new DefaultConfigurator();
    ModifiedConfigurator modifiedConfigurator = new ModifiedConfigurator();

    public Message modifyMessage(Message message) {
        message.setPayload(defaultConfigurator.configurePayload(message));
        return message;
    }

    public void defaultOutputMessage(Message message) {
        defaultConfigurator.configureOutput(message);
    }

    public void modifiedOutputMessage(Message message, String pathToSavedFile) {
        modifiedConfigurator.configureOutput(message, pathToSavedFile);
    }

    public void continueWithDefault(String PATH_TO_FILE) {
        Message currentMessage = MessageDAO.makeMessageFromJson(PATH_TO_FILE);

        modifyMessage(currentMessage);
        defaultOutputMessage(currentMessage);
    }

    public void continueWithUpdatedFilePath(String PATH_TO_FILE, String pathToSaveFile) {
        Message currentMessage = MessageDAO.makeMessageFromJson(PATH_TO_FILE);
        modifyMessage(currentMessage);
        modifiedOutputMessage(currentMessage, pathToSaveFile);
    }

    public Message modifiedModifyMessage(Message message, String[] handlersArray) {
        for (int i = 0; i< handlersArray.length; i++) {
            String handlerToUse = handlersArray[i];
            message.setPayload(modifiedConfigurator.configurePayload(message, handlerToUse));
        }
        return  message;
    }

    public void continueWithUpdatedHandlers(String PATH_TO_FILE, String[] handlersToUse){
        Message currentMessage = MessageDAO.makeMessageFromJson(PATH_TO_FILE);

        modifiedModifyMessage(currentMessage, handlersToUse);
        defaultOutputMessage(currentMessage);


    }
}
