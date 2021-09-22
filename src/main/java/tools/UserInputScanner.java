package tools;

import java.util.Scanner;

public class UserInputScanner {
    Scanner scanner = new Scanner(System.in);

    public String scannerString() {
        return scanner.nextLine();
    }
}
