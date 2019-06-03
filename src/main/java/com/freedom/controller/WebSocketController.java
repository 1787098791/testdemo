package com.freedom.controller;

import com.freedom.pojo.Message;
import com.freedom.service.WebSocketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebSocketController {
    @Autowired
    WebSocketInfo webSocketInfo;
    @ResponseBody
    @RequestMapping("getSocketPath")
    public Object getSocketPath(HttpServletRequest request){
        String path = request.getContextPath();//获取项目名
        String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
        System.out.println(path.length());
        return socketPath;
    }

    @ResponseBody
    @RequestMapping("saveInfo")
    public Object saveInfo(@RequestBody Message message){
        System.out.println(message);
        int i = webSocketInfo.insertInfo(message);
        return i;
    }
}
