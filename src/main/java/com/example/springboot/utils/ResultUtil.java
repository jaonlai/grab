package com.example.springboot.utils;

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
    public static ResponseDto error(Object object){
        ResponseDto result = new ResponseDto();
        result.setCode("00000");
        result.setMsg("操作失败");
        result.setData(object);
        return result;
    }
}
