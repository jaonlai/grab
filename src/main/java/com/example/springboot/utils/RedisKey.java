package com.example.springboot.utils;

public enum RedisKey {

    USER_TOKEN("SYS::USER::TOKEN","免费会员");

    RedisKey(String key, String des) {
        this.key = key;
        this.des = des;
    }

    private String key;
    private String des;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
