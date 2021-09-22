package tools;

import message.*;

public class Output {

    public void consoleOutput(Message message) {
        System.out.println(message.toString());
    }

    public void fileOutput (Message message, String path) {
        MessageDAO.makeJsonFromMessage(message, path);
    }
}
