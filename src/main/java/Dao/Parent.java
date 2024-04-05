package Dao;
public class Parent {
    String id;
    String parent_name;
    String relationship;
    String phone;
    public Parent(){}
    public Parent(String id, String parent_name, String relationship, String phone){
        this.id=id;
        this.parent_name = parent_name;
        this.relationship = relationship;
        this.phone = phone;
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
    public void setId(String id) {
        this.id = id;
    }
    public String getParent_name() {
        return parent_name;
    }
    public void setParent_name(String parentName) {
        this.parent_name = parentName;
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
}
