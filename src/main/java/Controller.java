import java.util.stream.Stream;

public class Controller {
    private Stream<String> stringStream;
    InputReader inputReader;

    public Controller(Stream<String> stringStream) {
        this.stringStream = stringStream;
        inputReader = new InputReader();
    }

    public Controller() {
        inputReader = new InputReader();
    }

    public String get() {
        return null;
    }

    public String set() {
        return null;
    }

    private String help(){
        return null;
    }

    public void run(){
        boolean whileGuard = true;

        while(whileGuard) {
            //TODO Maybe observer should be implement?
            switch (inputReader.lines().toUpperCase()) {
                case "SET":
                    set();
                    System.out.println("set received");
                    break;
                case "GET":
                    get();
                    System.out.println("get received");
                    break;
                case "HELP":
                    help();
                    break;
                case "EXIT":
                    System.out.println("Do zobaczenia!");
                    whileGuard = false;
                    break;
                default:
                    System.out.println("Command invalid try 'HELP' command");
            }
        }
    }
}
