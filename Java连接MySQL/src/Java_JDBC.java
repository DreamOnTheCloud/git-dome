import java.sql.*;

public class Java_JDBC {
    //8.0以上版本JDBC驱动以及URL地址与数据库名
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/" +
            "RUNOOB?" +
            "useSSL=false&" +
            "allowPublicKeyRetrieval=true&" +
            "serverTimezone=UTC";
    //RUNOOB:数据库名
    //useSSL ssl认证 :true/false
    //allowPublicKeyRetrieval:服务器认证
    //serverTimezone=UTC:时区

    //输入数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "3715";

    public static void main(String[] args) {
        //放在外面是因为用完要关闭(提高作用域)
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            //打开链接
            System.out.println("连接数据库.......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //conn.createStatement方法的返回值是Statement类型的,所以要用Statement来保存
            stmt = conn.createStatement();
            //创建SQL
            String sql;
            sql = "select * from websites";
            //查询语句executeQuery
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }

            //插入数据execultUpdate
            String insertsql =
                    "insert into websites values(null , '百度' , 'https://www.baidu.com' , 5 , 'CN')";
            //boolean result = stmt.execute(insertsql);
            //System.out.println(result);
            //上面的方法也是插入语句，下面也是
            int ressult = stmt.executeUpdate(insertsql);
            System.out.println(ressult);

            //修改数据
            // String updateSql
            // = "update websites set name = '信息工程学院' where name = '百度'";
            // stmt.executeUpdate(updateSql);

            //删除数据
            String deleteSql = "delete from websites where name = '信息工程学院'";
            int result2 = stmt.executeUpdate(deleteSql);
            System.out.println(result2);

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
        System.out.println("Goodbye!");
    }
}
