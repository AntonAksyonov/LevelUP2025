package lesson20;

import lesson19.DbRunner;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@UtilityClass
public class DBCPDataSource {

    private static BasicDataSource ds = new BasicDataSource();

    private static final Properties DB_PROPERTIES = new Properties();

    @SneakyThrows(IOException.class)
    private static void loadDbProperties() {
        DB_PROPERTIES.load(DbRunner.class.getResourceAsStream("/db/db.properties"));
    }

    static {
        loadDbProperties();
        ds.setUrl(DB_PROPERTIES.getProperty("db.url"));
        ds.setUsername(DB_PROPERTIES.getProperty("db.login"));
        ds.setPassword(DB_PROPERTIES.getProperty("db.password"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}