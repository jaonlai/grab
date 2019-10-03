package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/main")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param user
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping("/pass/user/login")
    public User userLogin(@Validated(value= User.Login.class) User user, BindingResult bindingResult) throws Exception {
        //验证错误
        this.validException(bindingResult);
        return (User) userService.findUserByName(user.getName(),user.getPwd());
    }

    /**
     * 用户注册
     * @param user
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping("/pass/user/reg")
    public User userReg(@Validated(value= User.Create.class) User user, BindingResult bindingResult) throws Exception {
        //验证错误
        this.validException(bindingResult);
        //md5 后的字符串
        byte[] md5=DigestUtils.md5Digest(user.getPwd().getBytes());
        String result = Encoder.md5(md5);
        user.setPwd(result);
        return userService.add(user);
    }

    @RequestMapping("/pass/user/error")
    public User userError(User user) throws Exception {
        throw new Exception("error");
    }




}
