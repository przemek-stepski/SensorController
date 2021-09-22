package message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import tools.*;

public class MessageDAO {

    static Message message;

    public static Message makeMessageFromJson(String pathToFile) throws MissingFileException, NullPointerException {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(pathToFile)) {

            Type messageType = new TypeToken<Message>() {}.getType();
            return message = gson.fromJson(reader, messageType);

        } catch (IOException e) {
            System.out.println("Reading Json file error occurred: " + e.getMessage());
            throw new MissingFileException();
        } catch (NullPointerException e) {
            System.out.println("Path to file should not be null: " + e.getMessage());
            throw new MissingFileException();
        } catch (JsonSyntaxException e) {
            System.out.println("File should be json format and not empty: " + e.getMessage());
            throw new MissingFileException();
        }
    }

    public static boolean makeJsonFromMessage(Message message, String pathToFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            gson.toJson(message, fileWriter);
            fileWriter.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Saving Json file error" + e.getMessage());
        }
        return false;
    }
}
