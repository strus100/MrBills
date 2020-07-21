import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputReaderTest {

    @Test
    @Disabled
    void name1(){
        InputReader inputReader = new InputReader();

        assertEquals("A",inputReader.lines());
    }


}
