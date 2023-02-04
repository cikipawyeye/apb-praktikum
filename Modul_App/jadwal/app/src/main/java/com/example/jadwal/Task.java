package com.example.jadwal;

public class Task {
    private String id;
    private String name;
    private String desc;
    private String date;

    public Task(String id, String name, String desc, String date) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.date = date;
    }

    public Task(String name, String desc, String date) {
        this.name = name;
        this.desc = desc;
        this.date = date;
    }

    public Task() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static final String KEY_ID = "id_activity";
    public static final String KEY_NAME = "name";
    public static final String KEY_DATE = "date";
    public static final String KEY_DESC = "description";
    public static final String TABLE = "activity";


}
