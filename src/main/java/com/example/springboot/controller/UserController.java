package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import com.example.springboot.pojo.UserReg;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.Encoder;
import com.example.springboot.utils.MySessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/main/user")
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
    @RequestMapping("/pass/login")
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
    @RequestMapping("/pass/reg")
    public User userReg(@Validated(value= User.Create.class) UserReg user, BindingResult bindingResult, HttpServletRequest httpServletRequest) throws Exception {
        //验证错误
        this.validException(bindingResult);
        String sessionId = httpServletRequest.getParameter("sessionId");
        MySessionContext myc= MySessionContext.getInstance();
        HttpSession httpSession = myc.getSession(sessionId);
        String createText = (String) httpSession.getAttribute("vrifyCode");
        System.out.println(user.getVrifyCode());
        System.out.println(createText);
        if(!createText.equals(user.getVrifyCode())){
            throw new Exception("验证码错误");
        }
        //md5 后的字符串
        String result =DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        user.setPwd(result);
        User userReal = new User();
        userReal.setPwd(user.getPwd());
        userReal.setName(user.getName());
        return userService.add(userReal);
    }

    @RequestMapping("/pass/user/error")
    public User userError(User user) throws Exception {
        throw new Exception("error");
    }




}
