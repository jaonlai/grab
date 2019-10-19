package com.example.springboot.controller;

import com.example.springboot.pojo.User;
import com.example.springboot.pojo.UserDetail;
import com.example.springboot.pojo.UserReg;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.Encoder;
import com.example.springboot.utils.MySessionContext;
import com.example.springboot.utils.ResponseDto;
import com.example.springboot.utils.ResultUtil;
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
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping("/pass/login")
    public ResponseDto userLogin(@Validated(value = User.Create.class) UserReg user, BindingResult bindingResult, HttpServletRequest httpServletRequest) throws Exception {
        if (!this.env.equals("dev")) {
            //验证错误
            this.validException(bindingResult);
            String sessionId = httpServletRequest.getParameter("sessionId");
            MySessionContext myc = MySessionContext.getInstance();
            HttpSession httpSession = myc.getSession(sessionId);
            if (httpSession == null) {
                throw new Exception("验证码已过期");
            }
            String createText = (String) httpSession.getAttribute("vrifyCode");
            System.out.println(user.getVrifyCode());
            System.out.println(createText);
            if (!createText.equals(user.getVrifyCode())) {
                throw new Exception("验证码错误");
            }
        }

        User userInfo = (User) userService.findUserByName(user.getName(), user.getPwd());
        String token = userInfo.getToken();
        return ResultUtil.success(token);
    }

    /**
     * 用户注册
     *
     * @param user
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping("/pass/reg")
    public User userReg(@Validated(value = User.Create.class) UserReg user, BindingResult bindingResult, HttpServletRequest httpServletRequest) throws Exception {
        if (!this.env.equals("dev")) {
            //验证错误
            this.validException(bindingResult);
            String sessionId = httpServletRequest.getParameter("sessionId");
            MySessionContext myc = MySessionContext.getInstance();
            HttpSession httpSession = myc.getSession(sessionId);
            if (httpSession == null) {
                throw new Exception("验证码已过期");
            }
            String createText = (String) httpSession.getAttribute("vrifyCode");
            System.out.println(user.getVrifyCode());
            System.out.println(createText);
            if (!createText.equals(user.getVrifyCode())) {
                throw new Exception("验证码错误");
            }
        }
        //md5 后的字符串
        String result = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        user.setPwd(result);
        User userReal = new User();
        userReal.setPwd(user.getPwd());
        userReal.setName(user.getName());
        return userService.addUserWithTrance(userReal, new UserDetail());
    }

    /**
     * 根据token 获取用户信息
     * @param token
     * @return
     * @throws Exception
     */
    @RequestMapping("/pass/user/token")
    public User userToken(String token) throws Exception {
       return getUserByToken(token);
    }

    /**
     *
     * @return
     */
    public Object getMenu(){

        return null;
    }

    @RequestMapping("/pass/user/error")
    public User userError(User user) throws Exception {
        throw new Exception("error");
    }


}
