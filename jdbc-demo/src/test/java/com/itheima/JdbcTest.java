package com.itheima;

import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;


public class JdbcTest {

    @Test
    public void testUpdate() throws Exception {
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2. 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1017";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

        //3. 获取SQL语句执行对象
        Statement statement = connection.createStatement();
        System.out.println(statement);

        //4. 执行SQL
        int i = statement.executeUpdate("update web01.user set age = 25 where id = 1");//DML
        System.out.println("SQL执行完毕影响的记录数为: " + i);

        //5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception {
        String DB_URL = "jdbc:mysql://localhost:3306/web01";
        String USER = "root";
        String PASS = "1017";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            String sql = "SELECT id, username, password, name, age FROM web01.user WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "daqiao");
            pstmt.setString(2, "123456");
            rs = pstmt.executeQuery();

            // 提取数据
            while (rs.next()) {
                // 创建 User 对象并设置属性值
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );

                // 输出 User 对象的数据
                System.out.println(user);
            }
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
