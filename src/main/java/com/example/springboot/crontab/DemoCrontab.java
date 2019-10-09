package com.example.springboot.crontab;

import com.example.springboot.utils.MySessionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Configuration //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling //开启定时任务

public class DemoCrontab {
    //3.添加定时任务
    @Scheduled(cron = "5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + System.currentTimeMillis());
        MySessionContext myc= MySessionContext.getInstance();
        //myc.clear();
    }
}
