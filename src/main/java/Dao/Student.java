package Dao;
public class Student {
    String id;
    String name;
    String birthdate;
    String idCard;
    public Student(){}
    public Student(String id, String name, String birthdate, String idCard){
        this.id=id;
        this.name = name;
        this.birthdate = birthdate;
        this.idCard = idCard;
    }
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
    public String getId() {
        return id;
    }
    public void setId(String i) {
        this.id = i;
    }
    public String getName() {
        return name;
    }
    public void setName(String username) {
        this.name = username;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }
    public String getIdCard(){
        return idCard;
    }
}
