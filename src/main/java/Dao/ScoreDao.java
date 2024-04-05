package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

public class ScoreDao {
    // 添加管理员
    public int addScore(Score score) {
        DBConn db = new DBConn();
        Connection conn = db.getConnection();

        try{
            String sql = "INSERT INTO score (id,term,chinese,math,english) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, score.getId());
            statement.setString(2, score.getTerm());
            statement.setInt(3, score.getChinese());
            statement.setInt(4, score.getMath());
            statement.setInt(5,score.getEnglish());

            statement.executeUpdate();

            return 1;
        } catch (SQLException e) {
            System.out.println("faile to connect");
            e.printStackTrace();
            return 0;
        }
    }
    // 获取所有管理员信息
    public List<Score> getAllScores() {
        List<Score> Scores = new ArrayList<>();
        DBConn db = new DBConn();
        Connection conn = db.getConnection();
        try{
            String sql = "SELECT * FROM score";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String term = resultSet.getString("term");
                int chinese = resultSet.getInt("chinese");
                int math = resultSet.getInt("math");
                int english = resultSet.getInt("english");
                Score score = new Score(id,term,chinese,math,english);
                Scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Scores;
    }

    //根据名字删除管理员
    public void deleteScoreById(String id) {
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "DELETE FROM score WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据username获取管理员信息
//    public Score getScoreByName(String username) {
//        Score Score = null;
//
//        DBConn db = new DBConn();
//        try(Connection conn = db.getConnection()){
//            String sql = "SELECT * FROM Scores WHERE username = ?";//table
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, username);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String name = resultSet.getString("username");
//                String password = resultSet.getString("password");
//
//                Score = new Score(name, password);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return Score;
//    }
}
