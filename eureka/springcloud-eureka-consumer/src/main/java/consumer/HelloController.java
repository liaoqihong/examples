package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consumer.remote.HelloRemote;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloRemote helloRemote;
	
	@RequestMapping("/{name}")
	public String index(@PathVariable("name") String name){
		System.out.println("consumer.hello.index");
		return helloRemote.hello(name);
	}
}
