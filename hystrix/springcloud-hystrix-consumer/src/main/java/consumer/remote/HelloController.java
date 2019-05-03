package consumer.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloRemote helloRemote;
	
	@RequestMapping("/{name}")
	public String index(@PathVariable("name") String name){
		System.out.println("hystrix server hello.index");
		return helloRemote.hello(name);
	}
}
