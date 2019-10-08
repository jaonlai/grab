package com.example.springboot.pojo;

import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
public class UserReg extends User {
    @NotNull(message = "sessionId 不能为空", groups = Create.class)
    private String sessionId;
    @NotNull(message = "验证码不能为空", groups = Create.class)
    private String vrifyCode;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getVrifyCode() {
        return vrifyCode;
    }

    public void setVrifyCode(String vrifyCode) {
        this.vrifyCode = vrifyCode;
    }
}
