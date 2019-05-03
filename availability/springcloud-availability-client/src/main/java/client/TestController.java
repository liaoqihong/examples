package client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${jdbc.url}")
    private String url;
    
    @Value("${jdbc.username}")
    private String username;
    
    @Value("${jdbc.password}")
    private String password;

    @RequestMapping("/index")
    public String index() {
    	System.out.println("test.index");
    	StringBuilder sb = new StringBuilder();
    	sb.append("url:").append(url).append("<br/>");
    	sb.append("username:").append(username).append("<br/>");
    	sb.append("password:").append(password);
        return sb.toString();
    }
	
}
