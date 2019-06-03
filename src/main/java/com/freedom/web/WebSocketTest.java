package com.freedom.web;



import com.alibaba.fastjson.JSONObject;
import com.freedom.pojo.Message;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 聊天服务器类
 * @author shiyanlou
 *
 */
@ServerEndpoint("/websocket")
public class WebSocketTest {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  // 日期格式化

    //用来存放每个客户端对应的WebSocketTest对象，适用于同时与多个客户端通信
    //所有与服务器的websocket连接的WebSocketTest对象的集合，每个对象里又有一个Session属性(客户端与服务端的连接对话)，
    public static CopyOnWriteArraySet<WebSocketTest> webSocketSet = new CopyOnWriteArraySet<WebSocketTest>();
    //若要实现服务端与指定客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static ConcurrentHashMap<Session,Object> webSocketMap = new ConcurrentHashMap<Session,Object>();

    //与某个客户端的连接会话，通过它实现定向推送(只推送给某个用户)
    private Session session;

    @OnOpen
    public void open(Session session) {
        this.session=session;
        webSocketSet.add(this);     //加入set中
        System.out.println(webSocketSet);
        //webSocketMap.put(id,this);
        // 添加初始化操作
        System.out.println("后台连接成功！！！！");
    }

    /**
     * 接受客户端的消息，并把消息发送给所有连接的会话
     *
     * @param message 客户端发来的消息
     * @param session 客户端的会话
     */
    @OnMessage
    public void getMessage(String message, Session session) {
        System.out.println("收到的消息:"+message+"！！！！！");
        //群发消息  如果还要实现私聊，就要判断Message中toId这个属性存不存在
        //根据toid是否为0判断群发还是私聊
        for (WebSocketTest item : webSocketSet) {
            try {
                item.sendAllMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }

    }

    @OnClose
    public void close() {
        // 添加关闭会话时的操作
        //断开连接时最好清除本客户端的WebSocketTest对象！！！！！！！！
        webSocketSet.remove(this);
        System.out.println("连接断开！！！");
    }

    @OnError
    public void error(Throwable t) {
        // 添加处理错误的操作
    }

    //给所有客户端发送信息
    public void sendAllMessage(String message)  {
        //解析json字符串为普通对象，使用到fastjson
        Message myMessage = JSONObject.parseObject(message, Message.class);
        //System.out.println(myMessage);
        String messageText = myMessage.getMessageText();
        //日期格式转换
        String format = DATE_FORMAT.format(new Date());
        //主体信息前加上发消息的时间
        myMessage.setMessageText(format+":  "+messageText);
        //System.out.println(messageText);
        //以json字符串的形式发送给客户端
        this.session.getAsyncRemote().sendText(JSONObject.toJSONString(myMessage));
    }


}