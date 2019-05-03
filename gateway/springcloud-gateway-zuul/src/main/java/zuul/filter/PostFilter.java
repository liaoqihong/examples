package zuul.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class PostFilter extends ZuulFilter {

	public Object run() {
		System.out.println("exec "+filterType()+" run");
		
		return null;
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
		return FilterType.POST.getType();
	}
	
}
