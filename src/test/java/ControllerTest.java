import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getTest(){
        File test = new File("tester.csv");
        try {
            test.createNewFile();
            FileWriter writer = new FileWriter(test);
            writer.write("PRZYKLADOWA KROTKA");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Controller controller = new Controller("tester.csv");
        assertEquals("PRZYKLADOWA KROTKA",controller.get());

        if (test.delete()) {
            System.out.println("Deleted the file: " + test.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    @Test
    void setTest(){
        File test = new File("tester2.csv");
        try {
            test.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Controller controller = new Controller("tester2.csv");

        controller.set("PRZYKLADOWA KROTKA");

        assertEquals(controller.get(),"PRZYKLADOWA KROTKA");

        if (test.delete()) {
            System.out.println("Deleted the file: " + test.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    @Test
    void helpMethodReturnStringHelp(){
        Controller controller = new Controller();

        assertEquals(controller.help(),"Help:\nGET - zwraca listę produktów, które zostały wprowadzone do systemu\nSET - inicjuje wprowadzanie do systemu, jeśli chcesz więcej informacji wpisz SET, a następnie HELP");
    }


}
