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

        FileManager fileManager = new FileManager("testRead.csv");
        Stream<String> string = fileManager.read();

        assertEquals("EXAMPLE",string.collect(Collectors.joining()));
    }

    @Test
    void write() throws IOException {
        File file = mockCreate("testWrite.csv");
        Stream<String> stream = Files.lines(Paths.get("testWrite.csv"));

        FileManager fileManager = new FileManager("testWrite.csv");
        fileManager.write("EXAMPLE");
        assertEquals("EXAMPLE",stream.collect(Collectors.joining()));
    }

    @Test
    void create(){
        File file = mockCreate("testCreate.csv");

        FileManager fileManager = new FileManager("testCreate.csv");
        fileManager.create();

        assertTrue(file.exists());
    }

    @Test
    void isCreated(){
        File file = mockCreate("testIsCreated.csv");

        FileManager fileManager = new FileManager("testIsCreated.csv");
        assertTrue(fileManager.isCreated());
    }
}
