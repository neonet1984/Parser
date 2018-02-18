package parser;

import model.YamlModel;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<YamlModel> yamlListAttributes;
    private List<StringBuilder> propertiesList;

    public Parser() {
        this.propertiesList = new ArrayList<>();
        this.yamlListAttributes = new ArrayList<>();
    }

    public List<StringBuilder> yamlToProperties(List<String> yamlListConfiguration) {
        for (String yamlConfiguration : yamlListConfiguration) {
            if (yamlConfiguration.isEmpty()) continue;
            if (!checkYamlAttribute(yamlConfiguration)) {
                int countSpace = this.getCountSpace(yamlConfiguration);
                this.clearConfiguration(countSpace);
                String yamlAttribute = this.getYamlAttribute(yamlConfiguration);
                yamlListAttributes.add(new YamlModel(countSpace, yamlAttribute));
            } else {
                StringBuilder propertiesConfig = new StringBuilder();
                int countSpace = getCountSpace(yamlConfiguration);
                yamlListAttributes.stream().
                        filter(item -> item.getCountSpace() < countSpace).
                        forEach(item -> propertiesConfig.append(item.getYamlAttribute()+"."));
                propertiesConfig.append(getKeyValue(yamlConfiguration));
                propertiesList.add(propertiesConfig);
            }
        }
        return propertiesList;

    }

    private boolean checkYamlAttribute(String yamlConfiguration) {
        int countYamlAttribure = yamlConfiguration.split(":").length;
        if (countYamlAttribure > 1)
            return true;
        else return false;
    }

    private String getYamlAttribute(String yamlConfiguration) {
        return yamlConfiguration.replace(":", "").trim();
    }

    private String getKeyValue(String yamlConfiguration) {
        yamlConfiguration = yamlConfiguration.replace(":", "=").
                replace(" ", "").replace("\"", "");
        return yamlConfiguration;
    }

    private int getCountSpace(String str) {
        int countSpace = 0;
        for (char symbol : str.toCharArray()) {
            if (symbol == ' ') countSpace++;
        }
        return countSpace;
    }

    private void clearConfiguration(int countSpace) {
        this.yamlListAttributes.removeIf(item -> item.getCountSpace() >= countSpace);
    }

}
