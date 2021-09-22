import app.AppController;

public class Main {
    public static void main(String[] args) {
        final String PATH_TO_FILE = args[0];

        AppController appController = new AppController(PATH_TO_FILE);
        appController.startApp();
    }
}
