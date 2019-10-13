package com.example.springboot.utils;

import java.awt.image.BufferedImage;

public class ResultUtil {
    //执行成功
    public static ResponseDto success(Object object){
        ResponseDto result = new ResponseDto();
        result.setCode("10000");
        result.setMsg("操作成功");
        result.setData(object);
        return result;
    }

    //执行失败
    public static ResponseDto error(Object object,String msg){
        ResponseDto result = new ResponseDto();
        result.setCode("00000");
        if(msg==null){
            msg="操作失败";
        }
        result.setMsg(msg);
        result.setData(object);

        return result;
    }
}
