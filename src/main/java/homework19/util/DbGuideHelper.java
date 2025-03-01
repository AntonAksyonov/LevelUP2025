package homework19.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@UtilityClass
public class DbGuideHelper {

    private static final Properties DB_CONNECTION_PROPERTIES = new Properties();

    static {
        loadDbConnectionProperties();
    }

    @SneakyThrows(IOException.class)
    private static void loadDbConnectionProperties() {
        DB_CONNECTION_PROPERTIES.load(DbGuideHelper.class.getResourceAsStream("/dbConnection.properties"));
    }

    private Connection connection = null;

    @SneakyThrows(SQLException.class)
    public PreparedStatement createPreparedStatement(String sql) {
        if (connection == null) {
            String jdbcUrl = DB_CONNECTION_PROPERTIES.getProperty("db.url");
            String login = DB_CONNECTION_PROPERTIES.getProperty("db.login");
            String password = DB_CONNECTION_PROPERTIES.getProperty("db.password");
            connection = DriverManager.getConnection(jdbcUrl, login, password);
            connection.setAutoCommit(false);
        }
        return connection.prepareStatement(sql);
    }

    @SneakyThrows(SQLException.class)
    public Integer getInteger(ResultSet rs, String columnName) {
        Integer result = rs.getInt(columnName);
        return rs.wasNull() ? null : result;
    }
}