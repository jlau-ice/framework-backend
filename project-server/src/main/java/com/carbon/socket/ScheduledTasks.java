//package com.carbon.socket;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.Session;
//import java.io.IOException;
//
//@Component
//public class ScheduledTasks {
//
//    private final SessionManager sessionManager;
//
//    @Autowired
//    public ScheduledTasks(SessionManager sessionManager) {
//        this.sessionManager = sessionManager;
//    }
//
//    @Scheduled(fixedRate = 2000)
//    public void sendMessage() throws IOException {
//        for (Session session : sessionManager.getSessionMap().values()) {
//            session.getBasicRemote().sendText("定时消息");
//        }
//    }
//}
