package com.cebbank.management_mms_product_consumer.controller;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@RabbitListener(queues = "orderQueue")
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer {

    //存放session的集合，很重要！！
    private static CopyOnWriteArraySet<WebSocketServer> sessions = new CopyOnWriteArraySet<WebSocketServer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收消息
    @RabbitHandler
    public void process(String message) throws IOException {
        onsend(message);
    }

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onopen(Session session) throws IOException {
        this.session=session;
        sessions.add(this);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onclose(Session session) {
        System.out.println("close....");
    }

    public void sendMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    //     * 收到客户端消息后调用的方法
//     * @param msg 客户端发送过来的消息
//     * @param session 可选的参数
//     */
    @OnMessage
    public void onsend(String msg) {
        try {
            if (sessions.size() != 0) {
                for (WebSocketServer s : sessions) {
                    if (s != null) {
                        s.session.getBasicRemote().sendText(msg);//向已连接客户端发送信息
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
