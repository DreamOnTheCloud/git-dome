import java.sql.*;

public class MySQLDemo {

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "3715";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

class HandleDatabase {

    //https://www.zhihu.com/question/271533176/answer/362588209
    //连接地址+ssl连接关闭+字符集为utf-8+时区设置
    //MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/runoob?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    // RUNOOB 数据库名
    // useSSL ssl认证
    // allowPublicKeyRetrieval 服务器认证
    // serverTimezone 时区


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "3715";

    public static void selectPrintScreen(String tableName) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER); //class反射不会  var driver = new Driver(); forName()不安全

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 初始化
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement(); // 获得封装的sql语句

            // 数据查询
            String sql = "select * from " + tableName;
            ResultSet rs = stmt.executeQuery(sql); //保存在rs中
            /**
             执行对象Statement提供两个常用的方法来执行SQL语句。
             executeQuery(Stringsql),该方法用于执行实现查询功能的sql语句，返回类型为ResultSet（结果集）。
             如：ResultSet  rs =stmt.executeQuery(sql);

             executeUpdate(Stringsql),该方法用于执行实现增、删、改功能的sql语句，返回类型为int，即受影响的行数。
             如：int flag = stmt.executeUpdate(sql);
             */

            // 展开结果集数据库
            while (rs.next()) { //返回逻辑值
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void appendRecord(String tableName, Object... fields) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER); //class反射不会  var driver = new Driver(); forName()不安全

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 初始化
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement(); // 获得封装的sql语句

            String sql = "insert into " + tableName + " values(" + fields[0] + ",'" + fields[1] + "')";//准备sql语句 注意：字符串要用单引号'
            stmt.executeUpdate(sql); //执行sql语句
            System.out.println("执行插入记录成功:"+ sql);

            // 完成后关闭
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void deleteRecord(String tableName, String condition, Object value) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER); //class反射不会  var driver = new Driver(); forName()不安全

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 初始化
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement(); // 获得封装的sql语句

            //准备sql语句
            String sql = "delete from " + tableName + " where " + condition + "='" + value + "'";//注意：字符串要用单引号'

            stmt.executeUpdate(sql); //执行sql语句
            System.out.println("执行删除记录成功:"+ sql);

            // 完成后关闭
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
    public static void updateRecord(String tableName,String condition, Object value, Object changeCondition,Object changeValue){
        /**
         完成利用sql语句实现对mysql数据表的修改
         tableName: 操作的数据库表名
         condition: 筛选条件字段
         value：筛选条件值
         changeCondition: 待修改的字段名
         changeValue: 待修改的字段值
         */
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER); //class反射不会  var driver = new Driver(); forName()不安全

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // 初始化
            System.out.println("实例化Statement对象...");
            stmt = conn.createStatement(); // 获得封装的sql语句

            //准备sql语句
            String sql = "update " + tableName + " set "+  changeCondition + " = '" + changeValue +
                    "' where "+condition + " = '" + value+ "'"; //注意：字符串要用单引号'

            stmt.executeUpdate(sql); //执行sql语句
            System.out.println("执行修改记录成功:"+ sql);

            // 完成后关闭
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
//        appendRecord("students", 1001, "test1"); //数据追加
//        appendRecord("students", 1002, "test2"); //数据追加
//        appendRecord("students", 1003, "test3"); //数据追加
//        appendRecord("students", 1006, "test"); //数据追加
//        selectPrintScreen("students"); //数据查询 并输出到控制台

//        updateRecord("students", "id", 1006,"name","update");//数据修改
//        selectPrintScreen("students");
//
        deleteRecord("students", "id", 1006); // 数据删除
        selectPrintScreen("students");

        System.out.println("Goodbye!");
    }
}
