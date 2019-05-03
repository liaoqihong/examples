package consumer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserService {

	//默认
	@HystrixCommand
	public Object getByDefaultProperties(Map<String,String> params){
		Map<String,String> user = newUser(params,"getUseDefault");
		sleep(1000*10);
		return user;
	}
	
	//设置超时后备方法
	@HystrixCommand(fallbackMethod="fallback")
	public Object getBySettedFallback(Map<String,String> params){
		Map<String,String> user = newUser(params,"getSettedFallback");
		sleep(1000*10);
		return user;
	}
	
	//设置超时时间
	@HystrixCommand(
		fallbackMethod="fallback",
		commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")}
	)
	public Object getBySettedTimeout(Map<String,String> params){
		Map<String,String> user = newUser(params,"getBySettedTimeout");
		sleep(1000*4);
		return user;
	}
	
	
	//设置超时时间
	@HystrixCommand(
		fallbackMethod="fallback",
		threadPoolKey="userThreadPoolKey"
	)
	public Object getBySettedThreadPool(Map<String,String> params){
		Map<String,String> user = newUser(params,"getSettedThreadPool");
		sleep(1000*4);
		return user;
	}
	
	
	
	@SuppressWarnings("unused")
	private Object fallback(Map<String,String> params){
		System.out.println("start fallback");
		if(params != null){
			System.out.println(params);
		}
		Map<String,String> user = newUser(params,"fallback");
		System.out.println("end fallback");
		return user;
	}
	
	
	private void sleep(long time){
		try {
			System.out.println("sleeping "+time);
			Thread.sleep(time);
			System.out.println("sleeped "+time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private Map<String,String> newUser(Map<String,String> params,String from){
		Map<String,String> user = new HashMap<String,String>();
		user.put("hashCode",user.hashCode()+"");
		user.put("username","admin");
		user.put("password","admin");
		user.put("from",from);
		return user;
	}
	
	
	
	
}
