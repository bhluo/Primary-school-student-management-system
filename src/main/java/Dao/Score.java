package Dao;
public class Score {
    String id;
    String term;
    int chinese;
    int math;
    int english;
    public Score(){}

    public Score(String id, String term, int chinese,int math,int english){
        this.id=id;
        this.term = term;
        this.chinese = chinese;
        this.math = math;
        this.english=english;
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
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public int getMath() {
        return math;
    }
    public void setEnglish(int english) {
        this.english=english;
    }
    public int getEnglish() {
        return english;
    }
    public void setMath(int math) {
        this.math=math;
    }
    public int getChinese() {
        return chinese;
    }
    public void setChinese(int chinese) {
        this.chinese=chinese;
    }

}
