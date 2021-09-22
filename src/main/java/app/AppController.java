package app;

import tools.*;

public class AppController {
    String PATH_TO_FILE;
    Menu menu;

    public AppController(String path) {
        PATH_TO_FILE = path;
        menu = new Menu(PATH_TO_FILE);
    }

    public void startApp() {
        menu.toMenu(PATH_TO_FILE);
    }
}
