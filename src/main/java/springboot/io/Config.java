package springboot.io;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	
	public final static String EXCHANGE = "e1";
	
	public final static String QUEUE = "q1";
	
	public final static String ROUTING_KEY = "r1";

    @Bean
    public DirectExchange e1() {
    	return new DirectExchange(EXCHANGE, false, true);
    }
    
    @Bean
    public Queue q1() {
    	return new Queue(QUEUE, false, false, true);
    }

    @Bean
    public Binding b1() {
    	return BindingBuilder.bind(q1()).to(e1()).with(ROUTING_KEY);
    }
}