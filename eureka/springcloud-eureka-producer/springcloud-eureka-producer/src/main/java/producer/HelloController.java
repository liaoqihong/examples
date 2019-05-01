package producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/{name}")
	public String index(@PathVariable("name") String name){
		System.out.println("producer.hello.index");
		System.out.println("Hello "+name+"!");
		return "Hello "+name+"!";
	}
}
