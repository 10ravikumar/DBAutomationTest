package database;

import org.jooq.Result;
import org.jooq.Record;
import org.jooq.impl.DSL;
import yaml.DBYamlModel;
import yaml.YamlFileReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseUtil {


    private Connection getDBConnection() throws SQLException {
        YamlFileReader yamlFileReader = new YamlFileReader();
        DBYamlModel yamlData = yamlFileReader.getYamlData();
        return DriverManager.getConnection(
                yamlData.getUrl(),
                yamlData.getUsername(),
                yamlData.getPassword());

    }


    public Result<Record> getQueryResult(String sqlQuery) throws SQLException {
        try (Connection c = getDBConnection()) {
            return DSL.using(c).fetch(sqlQuery);
        }
    }

    public <T> List<T> getQueryResultWithType(String sqlQuery, Class<T> className) throws SQLException {
       return getQueryResult(sqlQuery)
                .stream().map(e -> e.into(className)).toList();

    }

}
