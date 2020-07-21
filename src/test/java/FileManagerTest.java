import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void read(){
        FileManager fileManager = new FileManager("null.csv");
        fileManager.read();
    }

    @Test
    void write(){
        FileManager fileManager = new FileManager("null.csv");
        fileManager.write("EXAMPLE");
    }

    @Test
    void create(){
        FileManager fileManager = new FileManager("null1.csv");
        fileManager.create();
        File file = new File("null1.csv");

        assertTrue(file.exists());
    }

    @Test
    void isCreated(){
        FileManager fileManager = new FileManager("null.csv");
        fileManager.isCreated();
    }
}
