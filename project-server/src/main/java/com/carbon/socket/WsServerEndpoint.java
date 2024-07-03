package com.carbon.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/myWs")
@Component
@Slf4j
public class WsServerEndpoint {

    static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

//    private static SessionManager sessionManager;
//    @Autowired
//    public void setSessionManager(SessionManager sessionManager) {
//        WsServerEndpoint.sessionManager = sessionManager;
//    }
//
//    @OnOpen
//    public void onOpen(Session session) {
//        sessionManager.addSession(session.getId(), session);
//        log.info("连接成功");
//    }
//
//    @OnMessage
//    public String onMessage(String message) {
//        log.info("接收到消息:{}", message);
//        return "已经收到消息";
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        sessionManager.removeSession(session.getId());
//        log.info("连接关闭:{}", session.getId());
//    }


    @OnOpen
    public void onOpen(Session session) {
        sessionMap.put(session.getId(), session);
        log.info("连接成功");
    }

    @OnMessage
    public String onMessage(String message) {
        log.info("接收到消息:{}", message);
        return "已经收到消息";
    }

    @OnClose
    public void onClose(Session session) {
        sessionMap.remove(session.getId());
        log.info("连接关闭:{}", session.getId());
    }


    @Scheduled(fixedRate = 2000)
    public void sendMessage() throws IOException {
        for (String key : sessionMap.keySet()) {
            sessionMap.get(key).getBasicRemote().sendText("摩西摩西");
        }
    }
}


