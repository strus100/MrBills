import java.util.stream.Stream;

public class Controller {
    private Stream<String> stringStream;

    public Controller(Stream<String> stringStream) {
        this.stringStream = stringStream;
    }

    public String get() {
        return null;
    }
}
