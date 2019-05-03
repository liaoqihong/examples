package consumer.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name= "springcloud-eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name);
}
