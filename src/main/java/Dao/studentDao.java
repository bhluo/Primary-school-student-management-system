package Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConn;

//
//CREATE TABLE stu ( id VARCHAR(15) NOT NULL,name VARCHAR(20) NOT NULL, birthday VARCHAR(20) NOT NULL, idCard VARCHAR(30) NOT NULL );
public class studentDao {
    public boolean add(Student bean) {
        String username=bean.getName();
        System.out.println(username);
        System.out.println("addservice获取成功");
        System.out.println("addservice获取成功");
        DBConn db=new DBConn();
        Connection conn = db.getConnection();
        try {

            PreparedStatement pre=conn.prepareStatement("select * from stu where name=?");
            pre.setString(1,username);
            ResultSet rs=pre.executeQuery();
            if(!rs.next()){
                PreparedStatement pre1=conn.prepareStatement("insert into stu(id,name,birthday,idCard) VALUES(?,?,?,?)");
                pre1.setString(1, bean.getId());
                pre1.setString(2, bean.getName());
                pre1.setString(3, bean.getBirthdate());
                pre1.setString(4,bean.getIdCard());
                pre1.executeUpdate();
//			      不使用预处理语句
//				stat.executeUpdate(sql);
                PreparedStatement pre2=conn.prepareStatement("select * from stu order by id");
                ResultSet rs1=pre2.executeQuery();
                ResultSetMetaData metaData=pre2.getMetaData();
//			       得到结果集的列数
                int columnCount=metaData.getColumnCount();
                String []columnName=new String[columnCount];
                for(int i=0;i<columnName.length;i++){
//			   	得到列名
                    columnName[i]=metaData.getColumnName(i+1);
                }
//			      更新JavaBean数据模型
                bean.setColumnName(columnName);
//			      将游标移动到结果集的最后一行
                rs1.last();
//			      得到记录行号
                int rowNumber=rs1.getRow();
                String[][] tableRecord=bean.getTableRecord();
                tableRecord=new String[rowNumber][columnCount];
//			       将游标移动到结果集初始位置，第一行之前
                rs1.beforeFirst();
                int i=0;
                while(rs1.next()){
                    for(int k=0;k<columnCount;k++){
                        tableRecord[i][k]=rs1.getString(k+1);
                    }
                    i++;
                }
//			       更新JavaBean数据模型
                bean.setTableRecord(tableRecord);
                conn.close();
                pre.close();
                pre1.close();
                pre2.close();
                rs1.close();
                return true;
            }
            else
                return false;
        } catch (SQLException e) {
            System.out.println("数据库连接出错！");
            return false;
        }
    }
    //	****************************************找到IDservice**********************************************
    public List<Student> getAllStudents(){
        List<Student> stus = new ArrayList<>();
        DBConn dbConn = new DBConn();
        try (Connection conn = dbConn.getConnection()) {
            String sql = "SELECT * FROM stu";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                String stuid=rs.getString("id");
                String stuname=rs.getString("name");
                String stubirthday=rs.getString("birthday");
                String stuidCard=rs.getString("idCard");
                Student stu = new Student(stuid,stuname,stubirthday,stuidCard);
                stus.add(stu);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stus;
    }

    public void deleteStudentByName(String username) {
        DBConn db = new DBConn();
        try(Connection conn = db.getConnection()){
            String sql = "DELETE FROM stu WHERE name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
