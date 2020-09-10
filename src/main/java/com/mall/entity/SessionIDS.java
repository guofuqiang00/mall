package com.mall.entity;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

@Data
public class SessionIDS {

    HttpServletRequest request;


    private String sessionId;


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        request.setAttribute("SESSIONID",sessionId);
        this.sessionId = sessionId;

    }
}
