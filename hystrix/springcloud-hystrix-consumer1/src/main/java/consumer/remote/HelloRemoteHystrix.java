package consumer.remote;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HelloRemoteHystrix implements HelloRemote{
	
	public String hello(@PathVariable("name") String name){
        return "hello" +name+", this messge send failed ";
    }
}
