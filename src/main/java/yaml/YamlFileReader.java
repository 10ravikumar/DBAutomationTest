package yaml;


import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class YamlFileReader {

    public DBYamlModel getYamlData()  {
        Yaml yaml = new Yaml(new Constructor(DBYamlModel.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("database.yaml");
        DBYamlModel db = yaml.load(inputStream);
        return db;
    }
}
