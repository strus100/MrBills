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

}
