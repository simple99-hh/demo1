package com.example.util;

import java.sql.*;

/**
 * @author code clone detection group
 * @version 1.0
 * @email martinchan709@gmail.com
 */
public class JDBCTools {

    private static String url = "jdbc:oracle:thin:@192.168.168.5:1521:helowin";
    private static String name = "user01";
    private static String password = "1234";

    private static Connection connection;

    //加载驱动
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //创建连接
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    //连接结束释放资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {

        if (connection != null) {
            try {

                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
