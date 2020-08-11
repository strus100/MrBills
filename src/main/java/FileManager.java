import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileManager {
    File file;
    String filename;
    FileWriter writer;

    public FileManager(String filename) {
        this.file = new File(filename);
        this.filename = filename;
        try {
            this.writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stream<String> read() {
        try {
            return Files.lines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String toWrite) {
        try {
            writer.write(toWrite + '\n');
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create() {
        if(!isCreated()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isCreated() {
        if(file == null){
            return false;
        } else {
            return true;
        }
    }

    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
