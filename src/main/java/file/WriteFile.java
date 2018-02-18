package file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public void writeFile(List<StringBuilder> prop, String path) {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (StringBuilder propertiesConfiguration:prop) {
                writer.write(propertiesConfiguration.toString());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

