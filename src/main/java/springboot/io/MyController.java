package springboot.io;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MyController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        
    	this.rabbitTemplate.convertAndSend(Config.EXCHANGE, Config.ROUTING_KEY, "Parameter: " + name);
    	
    	model.addAttribute("name", name);
        return "greeting";
    }	
    
}
