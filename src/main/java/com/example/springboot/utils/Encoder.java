package com.example.springboot.utils;

import java.util.Base64;

public class Encoder {

    /**
     * md5 加密后的 byte 转为 string
     * @param md5
     * @return
     */
    public static String md5(byte[] md5){
        String result= new String("");
        //方案1 与 0xFF 即与 11111111 按位运算
        /*for (int i = 0; i < md5.length; i++) {
            String tmp = Integer.toHexString(md5[i] & 0xFF);
            if (tmp.length() == 1) {
                result += "0" + tmp;
            } else {
                result += tmp;
            }
        }*/
        //方案2按base64生成
        Base64.Encoder base64Encoder = Base64.getEncoder();
        result=base64Encoder.encodeToString(md5);
        return result;
    }
}
