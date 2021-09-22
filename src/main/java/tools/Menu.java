package tools;

import message.MessageManager;

public class Menu {
    UserInputScanner userInputScanner = new UserInputScanner();
    MessageManager messageManager = new MessageManager();

    public Menu(String path) {
        this.PATH_TO_FILE = path;
    }

    String PATH_TO_FILE;

    public void displayMenu() {
        System.out.println("***********************************************");
        System.out.println("Choose an option and press ENTER");
        System.out.println("1: Continue with default settings");
        System.out.println("2: Configure sensor settings");
        System.out.println("3: Choose new path to file to save sensor message");
        System.out.println("Q: Quit app");
        System.out.println("***********************************************");
    }

    protected String menuChoice() {
        return userInputScanner.scannerString();
    }

    public void executeCommand(String choice, String path) {
        switch (choice) {
            case "1":
                messageManager.continueWithDefault(PATH_TO_FILE);
                break;
            case "2":
                System.out.println("Type handlers you want to use \"trim\" \"add\" \"pad\" (separate with coma)");
                String[] handlersArray = userInputScanner.scannerString().split(",");
                messageManager.continueWithUpdatedHandlers(PATH_TO_FILE,handlersArray);
                break;
            case "3":
                System.out.println("Type path where sensor message will be saved ");
                String pathToSavedfile = userInputScanner.scannerString();
                messageManager.continueWithUpdatedFilePath(PATH_TO_FILE, pathToSavedfile);
                break;
            case "Q":
                System.out.println("You have successfully closed app. Thanks for using ;-)");
                break;
        }
        if (!choice.equals("Q")) {
            toMenu(PATH_TO_FILE);
        }
    }

    public void toMenu(String path) {
        displayMenu();
        executeCommand(menuChoice(), path);
    }
}
