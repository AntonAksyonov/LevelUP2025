package homework19.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@UtilityClass
public class DbGuideHelper {

    private Connection connection = null;

    @SneakyThrows(SQLException.class)
    public PreparedStatement createPreparedStatement(String jdbcUrl,
                                                     String login,
                                                     String password,
                                                     String sql) {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                    "root", "root");
            connection.setAutoCommit(false);
        }
        return connection.prepareStatement(sql);
    }

    @SneakyThrows(SQLException.class)
    public PreparedStatement createPreparedStatement(String sql) {
        return connection.prepareStatement(sql);
    }

    @SneakyThrows(SQLException.class)
    public Integer getInteger(ResultSet rs, String columnName) {
        Integer result = rs.getInt(columnName);
        return rs.wasNull() ? null : result;
    }
}