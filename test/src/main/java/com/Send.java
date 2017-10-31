package com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send
{
    private final static String QUEUE_NAME = "hello";
    
    public static void main(String[] argv)
        throws Exception
    {
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("123.249.81.134");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("adminpasspord");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!2222";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        
        channel.close();
        connection.close();
    }
}
