package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class BaseController {

    protected User getUserByToken(String token){

        return null;
    }

    public void validException(BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            for(ObjectError error: bindingResult.getAllErrors()){
                throw  new Exception(error.getDefaultMessage());
            }
        }

    }

}
