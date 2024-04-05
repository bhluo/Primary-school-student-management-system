package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DBConn;

public class EventDao {
    // 添加管理员
    public int addEvent(Event event) {
        DBConn db = new DBConn();
        Connection conn = db.getConnection();

        try{
            String sql = "INSERT INTO reward_punishment (id,event_date,event_type,detail) VALUES (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, event.getId());
            statement.setString(2, event.getEvent_date());
            statement.setString(3, event.getEvent_type());
            statement.setString(4, event.getDetail());

            statement.executeUpdate();

            return 1;
        } catch (SQLException e) {
            System.out.println("faile to connect");
            e.printStackTrace();
            return 0;
        }
    }
    // 获取所有管理员信息
    public List<Event> getAllEvents() {
        List<Event> Events = new ArrayList<>();
        DBConn db = new DBConn();
        Connection conn = db.getConnection();
        try{
            String sql = "SELECT * FROM reward_punishment";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String date=resultSet.getString("event_date");
                String type=resultSet.getString("event_type");
                String detail=resultSet.getString("detail");
                Event event = new Event(id,date,type,detail);
                Events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Events;
    }

    //根据名字删除管理员
    public void deleteEventById(String id) {
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "DELETE FROM reward_punishment WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据username获取管理员信息
//    public Event getEventByName(String username) {
//        Event Event = null;
//
//        DBConn db = new DBConn();
//        try(Connection conn = db.getConnection()){
//            String sql = "SELECT * FROM Events WHERE username = ?";//table
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, username);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String name = resultSet.getString("username");
//                String password = resultSet.getString("password");
//
//                Event = new Event(name, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return Event;
//    }
}
