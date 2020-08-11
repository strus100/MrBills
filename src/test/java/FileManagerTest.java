import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    File mockCreate(String name){
        File file = new File(name);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Test
    void read() throws IOException {
        File file = mockCreate("testRead.csv");

        FileWriter writer = new FileWriter(file);
        writer.write("EXAMPLE");
        writer.flush();
        writer.close();

        FileManager fileManager = new FileManager("testRead.csv");
        Stream<String> string = fileManager.read();
        fileManager.close();

        assertEquals("EXAMPLE",string.collect(Collectors.joining()));

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file: " + file.getName());
        }
    }

    @Test
    void write() throws IOException {
        File file = mockCreate("testWrite.csv");
        Stream<String> stream = Files.lines(Paths.get("testWrite.csv"));

        FileManager fileManager = new FileManager("testWrite.csv");
        fileManager.write("EXAMPLE");
        fileManager.close();
        assertEquals("EXAMPLE",stream.collect(Collectors.joining()));

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file:" + file.getName());
        }
    }

    @Test
    void create(){
        File file = mockCreate("testCreate.csv");

        FileManager fileManager = new FileManager("testCreate.csv");
        fileManager.create();
        fileManager.close();

        assertTrue(file.exists());

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file:" + file.getName());
        }
    }

    @Test
    void isCreated(){
        File file = mockCreate("testIsCreated.csv");

        FileManager fileManager = new FileManager("testIsCreated.csv");
        assertTrue(fileManager.isCreated());

        fileManager.close();

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file: " + file.getName());
        }
    }
}
