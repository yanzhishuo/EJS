//package com.cebbank.management_mms_product_consumer.service.impl;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//
//
//@Slf4j
//@Component("mqService")
//public class MqServiceImpl {
//
//    public static String msg;
//
//    @RabbitListener(queues = "orderQueue")
//    public void receiveOrderMsg(String message){
//        log.info("【队列消息】ReceiverMsg ,printMQ={}",message);
//        msg=message;
//    }
//
//}
