package com.quynhlm.dev.devonthi5.Model;

public class SinhVien {
    private int id;
    private String name;
    private int Birthday;
    private String MSSV;

    public SinhVien() {
    }

    public SinhVien(int id, String name, int birthday, String MSSV) {
        this.id = id;
        this.name = name;
        Birthday = birthday;
        this.MSSV = MSSV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return Birthday;
    }

    public void setBirthday(int birthday) {
        Birthday = birthday;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }
}
