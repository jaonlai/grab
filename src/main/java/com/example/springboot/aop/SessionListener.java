package com.example.springboot.aop;

import com.example.springboot.utils.MySessionContext;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class SessionListener implements HttpSessionListener {

    public static Map userMap = new HashMap();
    private MySessionContext myc=MySessionContext.getInstance();
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("-------------------------------------------------------" +
                "session create -------------------------------------------------------" +
                "-----------------");
        myc.AddSession(httpSessionEvent.getSession());
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        myc.DelSession(session);
    }


}
