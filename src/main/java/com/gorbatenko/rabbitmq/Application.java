package com.gorbatenko.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Value("${rabbitmq.queueName}")
    private String queueName;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend(queueName, "Hello, world!");
    }



    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void listen(String message) {
        System.out.println("Listener: " + message);
    }
}
