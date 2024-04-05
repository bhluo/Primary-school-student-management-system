package Dao;

public class Admin {
    private String username;
    private String password;
    //	存放列名
    String []columnName;
    //	存放记录
    String [][]tableRecord=null;
    public String[] getColumnName() {
        return columnName;
    }
    public void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }
    public String[][] getTableRecord() {
        return tableRecord;
    }
    public void setTableRecord(String[][] tableRecord) {
        this.tableRecord = tableRecord;
    }
    public Admin(){}
    // 构造函数和Getter/Setter方法
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // 其他管理员管理相关的方法
}
