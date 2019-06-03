<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/1
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户A</title>
</head>
<body>


<div id="content">


</div>


    <input type="text" id="info">
    <button type="button" onclick="sendmessage()">确认</button>
    <button type="button" onclick="closeConnected()">关闭连接</button>


<script src="jquery/jquery-2.1.1.min.js"></script>
<script>
    var socketPath;
    //请求后端获取socketPath
    $.ajax({
        async:false,
        url:"getSocketPath",
        type:"get",
        dataType:"text",
        success:function (data) {
            //alert(data);
            socketPath=data;
        }

        })


/*    function WebSocketTest()
    {
        if ("WebSocket" in window) {
            alert("您的浏览器支持 WebSocket!");*/
           var webSocket = new WebSocket("ws://"+socketPath+"websocket");
            webSocket.onopen = function(event){
                console.log("连接成功");
                console.log(event);
            };
            webSocket.onerror = function(event){
                console.log("连接失败");
                console.log(event);
            };
            webSocket.onclose = function(event){
                console.log("Socket连接断开");
                console.log(event);
            };
            webSocket.onmessage = function(event){
                //接受来自服务器的消息
                //...
            var $content = $("#content");
            var text = $content.html();
            var mydata = event.data;//得到的是json字符串
            console.log(typeof (mydata))
            var parse = JSON.parse(mydata);
            var info = parse.messageText;
            console.log(info)

            $content.html(text+"</br>"+info);
            }


     /*   else
        {
            // 浏览器不支持 WebSocket
            alert("您的浏览器不支持 WebSocket!");
        }
    }*/
    /*测试浏览器支不支持websocket,支持就开始下面的操作*/
   // WebSocketTest();
   function sendmessage(){

       var msg= $("#info").val();
       var data={
           messageText:msg
       }
       //以json字符串的形式发送数据
       webSocket.send(JSON.stringify(data));
       $("#info").val("");
   }

   function closeConnected(){
       $.ajax({
           async:true,
           url:"saveInfo",
           type:"post",
           data:JSON.stringify({
               "messageText":$("#content").html()
           }),
           contentType:"application/json;charset=utf-8",
           dataType:"json",
           success:function (data) {

           }

       })
       webSocket.close();

   }
</script>
</body>
</html>
