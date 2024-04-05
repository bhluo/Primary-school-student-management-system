package db;
import java.sql.*;
import org.apache.commons.dbcp2.BasicDataSource;
public class DBConn {
    public Connection getConnection() {
//        try {
////			加载注册驱动程序
//            try {
////                Class.forName("org.gjt.mm.mysql.Driver");
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            String url="jdbc:mysql://localhost:3306/loginlab?user=root&password=123456&characterEncoding=gb2312";
//            return DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;

        BasicDataSource ds = null;
        ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/loginlab");
        ds.setUsername("root");
        ds.setPassword("123456");
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setInitialSize(5);  // 设置连接池初始大小

        ds.setMaxTotal(20);
        Connection conn = null;
        try {
            conn=ds.getConnection();
            return conn;
        } catch (SQLException e) {
            System.out.println("dbconn错误");
            e.printStackTrace();
        }
        return conn;
    }
}
