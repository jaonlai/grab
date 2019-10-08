package com.example.springboot.controller;


import com.example.springboot.utils.MySessionContext;
import com.example.springboot.utils.ResponseDto;
import com.example.springboot.utils.ResultUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/main/kaptcha")
public class KaptchaController extends BaseController{
    @Autowired
    DefaultKaptcha defaultKaptcha;

    @RequestMapping("/data")
    public ResponseDto getImage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String vrifyCode=defaultKaptcha.createText();
        Map map = new HashMap<String,String>();
        httpServletRequest.getSession().setAttribute("vrifyCode",vrifyCode);
        map.put("seesionId",httpServletRequest.getSession().getId());
        map.put("url","/kaptcha/img?sessionId="+httpServletRequest.getSession().getId());
        return ResultUtil.success(map);

    }

    @RequestMapping("/img")
    public void createkaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        //生产验证码字符串并保存到session中
        //String createText = defaultKaptcha.createText();
        //httpServletRequest.getSession().setAttribute("vrifyCode", createText);
        //String createText = httpServletRequest.getSession().
        //System.out.println(httpServletRequest.getSession().getId());

        //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
        String sessionId = httpServletRequest.getParameter("sessionId");
        if(sessionId==null){
            throw new Exception("sessionId 不能为空");
        }
        MySessionContext myc= MySessionContext.getInstance();
        HttpSession httpSession = myc.getSession(sessionId);
        String createText = (String) httpSession.getAttribute("vrifyCode");

        BufferedImage challenge = defaultKaptcha.createImage(createText);
        ImageIO.write(challenge, "jpg", jpegOutputStream);

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
