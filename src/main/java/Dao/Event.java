package Dao;
public class Event {
   String id;
   String event_date;
   String event_type;
   String detail;
   public Event(){}

 public Event(String id,String event_date,String event_type,String detail){
     this.id=id;
     this.event_date=event_date;
     this.event_type=event_type;
     this.detail=detail;
 }
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
    public String getEvent_date() {
        return event_date;
    }
    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }
    public String getEvent_type() {
        return event_type;
    }
    public void setEvent_type(String event_type) {
        this.event_type=event_type;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

}
