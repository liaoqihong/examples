package zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter {

	public Object run() {
		System.out.println("exec "+filterType()+" run");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        String forbid = request.getParameter("forbid");
        if(!"true".equals(forbid)){
        	System.out.println("对请求进行路由");
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
        	System.out.println("不对其进行路由");
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
	}

	public boolean shouldFilter() {
		System.out.println("exec "+filterType()+" shouldFilter");
		return true;
	}

	public int filterOrder() {
		System.out.println("exec "+filterType()+" filterOrder");
		return 1;
	}

	public String filterType() {
		return FilterType.PRE.getType();
	}
	
}
