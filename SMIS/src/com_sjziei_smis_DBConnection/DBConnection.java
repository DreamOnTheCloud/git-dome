package com_sjziei_smis_DBConnection;

import java.sql.*;

public class DBConnection {

    //DRIVER驱动
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //MySQL 8.0以上版本  --JDBC数据库URL
    private static final String URL = "jdbc:mysql://localhost:3306/smis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    //私有变量Mysql数据库用户名和密码
    private static final String USER = "root";
    private static final String PASSWORD = "3715";
    //Connection用于连接数据库
    private Connection conn;

    public DBConnection() {
        try {
            try {
                //注册驱动别忘记try/catch环绕
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("连接数据库.......");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取Connection
    public Connection getConn() {
        return conn;
    }

    //关闭Connection
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

