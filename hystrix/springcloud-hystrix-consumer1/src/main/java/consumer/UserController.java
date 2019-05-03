package consumer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import consumer.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/{id}")
	public Object get(@PathVariable("id") String id){
		Map<String,String> params = new HashMap<String,String>();
		params.put("id","用户ID="+id);
		
		System.out.println("hystrix server hello.index");
		Object user = userService.getBySettedTimeout(params);
		user = userService.getBySettedFallback(params);
		System.out.println(user);
		
		return user;
		
	}

}
