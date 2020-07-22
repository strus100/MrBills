import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    @Disabled
    void test1(){
        Stream<String> mockStream =  Stream.of("set", "PRZYKLADOWA KROTKA", "get");
        Controller controller = new Controller(mockStream);

        assertEquals(controller.get(),"PRZYKLADOWA KROTKA");
    }

    @Test
    @Disabled
    void test2(){
        Stream<String> mockStream =  Stream.of("set", "PRZYKLADOWA KROTKA", "get");
        Controller controller = new Controller(mockStream);
        controller.set("PRZYKLADOWA KROTKA");

        assertEquals(controller.get(),"PRZYKLADOWA KROTKA");
    }

    @Test
    void helpMethodReturnStringHelp(){
        Controller controller = new Controller();

        assertEquals(controller.help(),"Help:\nGET - zwraca listę produktów, które zostały wprowadzone do systemu\nSET - inicjuje wprowadzanie do systemu, jeśli chcesz więcej informacji wpisz SET, a następnie HELP");
    }


}
