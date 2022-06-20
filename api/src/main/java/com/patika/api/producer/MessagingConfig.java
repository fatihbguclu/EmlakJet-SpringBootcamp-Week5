package com.patika.api.producer;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MessagingConfig {
    @Value("${queue.name}")
    private String queueName;

    @Value("${spring.rabbitmq.template.exchange}")
    private String topicExchangeName;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingName;

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }


    MessageConverter messageConverter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new SimpleMessageConverter());
        return rabbitTemplate;
    }
}