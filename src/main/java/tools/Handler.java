package tools;

import java.time.Instant;

public class Handler {

    public String trim(String string) {
        return string.trim();
    }

    public String padToMultiple(String string) {
        char PAD_CHAR = '#';
        int N = 5;
        int MULTIPLICATION = 2;

        return String.format("%-" + MULTIPLICATION * N + "s", string).replace(' ', PAD_CHAR);
    }

    public String addTimestamp(String string) {
        return string + "_" + Instant.now().getEpochSecond();
    }
}
