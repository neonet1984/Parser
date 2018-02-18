package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private BufferedReader reader;

    private void openFile(String patch) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(patch));
    }

    public List<String> readYaml(String path) throws IOException {
        this.openFile(path);
        String line;
        List fileYaml = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            fileYaml.add(line);
        }
        this.closeFile();
        return fileYaml;
    }

    public void closeFile() throws IOException {
        this.reader.close();
    }
}
