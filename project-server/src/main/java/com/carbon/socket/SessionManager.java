package com.carbon.socket;

import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    private final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    public void addSession(String sessionId, Session session) {
        sessionMap.put(sessionId, session);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public Map<String, Session> getSessionMap() {
        return sessionMap;
    }
}


