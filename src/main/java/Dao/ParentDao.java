package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConn;

public class ParentDao {
    // 添加管理员
    public int addParent(Parent parent) {
        DBConn db = new DBConn();
        Connection conn = db.getConnection();
        try{
            String sql = "INSERT INTO parent_info (id,parent_name,relationship,phone) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, parent.getId());
            statement.setString(2, parent.getParent_name());
            statement.setString(3, parent.getRelationship());
            statement.setString(4, parent.getPhone());
            statement.executeUpdate();
            System.out.println(parent.getParent_name()+":"+parent.getId());
            return 1;
        } catch (SQLException e) {
            System.out.println("faile to connect");
            e.printStackTrace();
            return 0;
        }
    }
    // 获取所有管理员信息
    public List<Parent> getAllParents() {
        List<Parent> Parents = new ArrayList<>();
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "SELECT * FROM parent_info";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String parent_name = resultSet.getString("parent_name");
                String relationship = resultSet.getString("relationship");
                String phone = resultSet.getString("phone");
                Parent parent = new Parent(id,parent_name,relationship,phone);
                Parents.add(parent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Parents;
    }

    //根据名字删除管理员
    public void deleteParentById(String id) {
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "DELETE FROM parent_info WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据username获取管理员信息
//    public Parent getParentByName(String username) {
//        Parent Parent = null;
//
//        DBConn db = new DBConn();
//        try(Connection conn = db.getConnection()){
//            String sql = "SELECT * FROM Parents WHERE username = ?";//table
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, username);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String name = resultSet.getString("username");
//                String password = resultSet.getString("password");
//
//                Parent = new Parent(name, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return Parent;
//    }
}
