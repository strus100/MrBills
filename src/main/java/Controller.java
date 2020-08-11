import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    InputReader inputReader;
    private String name;
    FileManager fileManager;

    public Controller(String testName){
        inputReader = new InputReader();
        this.name = testName;

        fileManager = new FileManager(name);
    }

    public Controller() {
        inputReader = new InputReader();
        this.name = "recipts.csv";

        fileManager = new FileManager(name);
    }

    public String get() {
        String x = fileManager.read().collect(Collectors.joining());
        fileManager.close();
        return x;
    }

    public void set(String string) {
        fileManager.write(string);
    }

    public String help(){
        return "Help:\nGET - zwraca listę produktów, które zostały wprowadzone do systemu\nSET - inicjuje wprowadzanie do systemu, jeśli chcesz więcej informacji wpisz SET, a następnie HELP";
    }

    public void run(){
        System.out.println("Witaj! Rozpocznij pracę, jeśli potrzebujesz pomocy wpisz HELP\nMrBills @2020 Daniel Matuszewski");
        boolean whileGuard = true;

        while(whileGuard) {
            //TODO Maybe observer should be implement?
            switch (inputReader.lines().toUpperCase()) {
                case "SET":
                    set(inputReader.lines());
                    break;
                case "GET":
                    System.out.println(get());
                    break;
                case "HELP":
                    System.out.println(help());
                    break;
                case "EXIT":
                    System.out.println("Do zobaczenia!");
                    whileGuard = false;
                    break;
                default:
                    System.out.println("Komenda nieprawidłowa wpisz HELP by uzyskać pomoc");
            }
        }
    }
}
