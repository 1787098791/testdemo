package com.freedom.service.imp;

import com.freedom.mapper.WebSocketMapper;
import com.freedom.pojo.Message;
import com.freedom.service.WebSocketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSocketInfoImp implements WebSocketInfo {
    @Autowired
    WebSocketMapper webSocketMapper;
    public int insertInfo(Message message) {
        int i = webSocketMapper.insertInfo(message);
        return i;
    }
}
