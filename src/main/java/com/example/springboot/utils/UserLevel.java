package com.example.springboot.utils;

public enum UserLevel {

    FREE_USER(1,"免费会员"),
    MONTH_USER(2,"月会员"),
    YEAR_USER(3,"年会员");

    private int level;
    private String des;

    UserLevel(int level, String des) {
        this.level = level;
        this.des = des;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
