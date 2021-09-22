package tools;

public class MissingFileException extends RuntimeException{

    public MissingFileException() {};

    public MissingFileException(String message) {
        super(message);
    }
}
