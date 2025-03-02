package lesson19.util;

import lesson20.DBCPDataSource;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
//        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
//                "root", "root");
        Connection connection = DBCPDataSource.getConnection();
        connection.setAutoCommit(false);
        return connection.prepareStatement(sql);
    }

    @SneakyThrows(SQLException.class)
    public PreparedStatement createPreparedStatement(String sql) {
        Connection connection = DBCPDataSource.getConnection();
        connection.setAutoCommit(false);
        return connection.prepareStatement(sql);
    }

    @SneakyThrows(SQLException.class)
    public CallableStatement createCallableStatement(String jdbcUrl,
                                                     String login,
                                                     String password,
                                                     String sql) {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                "root", "root");
        connection.setAutoCommit(false);
        return connection.prepareCall(sql);
    }

//    public void analyzeDb(String jdbcUrl, String login, String password) throws SQLException {
//        Connection connection = DBCPDataSource.getConnection();
//        DatabaseMetaData metaData = connection.getMetaData();
//        metaData.get
//    }

    @SneakyThrows(SQLException.class)
    public Integer getInteger(ResultSet rs, String columnName) {
        Integer result = rs.getInt(columnName);
        return rs.wasNull() ? null : result;
    }
}