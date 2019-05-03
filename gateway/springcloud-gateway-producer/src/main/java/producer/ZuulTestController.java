package producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zuulTest")
public class ZuulTestController {

	@RequestMapping("/welcome/{name}")
	public String welcome(@PathVariable("name") String name){
		System.out.println("ZuulTestController.Welcome");
		System.out.println("Welcome "+name+"!");
		return "Welcome "+name+"!";
	}
	
	@RequestMapping("/retry")
	public String retry(){
	    System.out.println("retry...");
	    try{
	        Thread.sleep(1000000);
	    }catch ( Exception e){
	        e.printStackTrace();
	    }
	    return "this is two messge";
	}
	
	@RequestMapping("/fallback")
	public String fallback(){
	    System.out.println("fallback...");
	    throw new RuntimeException("fallback RuntimeException");
	}
	
	
}
