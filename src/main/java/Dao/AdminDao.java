package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class AdminDao {
    // 添加管理员
    public int addAdmin(Admin admin) {
        DBConn db = new DBConn();
        System.out.println("密码：");
        System.out.println(admin.getUsername());
        System.out.println(admin.getPassword());
        try(Connection conn = db.getConnection()){
            String sql = "INSERT INTO admins (username, password) VALUES (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());
            statement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("faile to connect");
            e.printStackTrace();
            return 0;
        }
    }
    public int checkLogin(Admin bean) {
//		从JavaBean中获得属性值
        String username = bean.getUsername();
        String password = bean.getPassword();
//		创建连接
        DBConn db = new DBConn();
        Connection conn = db.getConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("select * from admins where username='" + username+ "' and password='"+password+"'");
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                pre.close();
                rs.close();
                return 1;
            }
            else if (conn.prepareStatement("select * from admins where username='" + username + "'").executeQuery().next()){
                return 2;
            }
            else
                //用户不存在
                return 0;
        } catch (SQLException e) {
            System.out.println("数据库连接出错");
            return -1;
        }
    }

    // 获取所有管理员信息
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "SELECT * FROM admins";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Admin admin = new Admin(username, password);
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

     //根据名字删除管理员
    public void deleteAdminByName(String username) {
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "DELETE FROM admins WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     //根据username获取管理员信息
    public Admin getAdminByName(String username) {
        Admin admin = null;

        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "SELECT * FROM admins WHERE username = ?";//table
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");

                admin = new Admin(name, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
