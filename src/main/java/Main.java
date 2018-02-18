import file.ReadFile;
import file.WriteFile;
import parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        WriteFile writeFile = new WriteFile();
        BufferedReader readerPatch = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Enter the path to the YAML file");
        String pathYaml = readerPatch.readLine();
        System.out.println("path to save the file properties");
        String pathProperties = readerPatch.readLine();
        ReadFile readFile = new ReadFile();
        List yamlFile = readFile.readYaml(pathYaml);
        List<StringBuilder> propertiesList = parser.yamlToProperties(yamlFile);
        writeFile.writeFile(propertiesList,pathProperties);

    }
}
