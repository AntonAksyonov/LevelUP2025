package lesson19.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@UtilityClass
public class DbHelper {

    @SneakyThrows(SQLException.class)
    public Statement createStatement(String jdbcUrl, String login, String password) {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                        "root", "root")
                .createStatement();
    }

    @SneakyThrows(SQLException.class)
    public PreparedStatement createPreparedStatement(String jdbcUrl,
                                                     String login,
                                                     String password,
                                                     String sql) {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "root", "root");
        connection.setAutoCommit(false);
        return connection.prepareStatement(sql);
    }

    @SneakyThrows(SQLException.class)
    public Integer getInteger(ResultSet rs, String columnName) {
        Integer result = rs.getInt(columnName);
        return rs.wasNull() ? null : result;
    }
}