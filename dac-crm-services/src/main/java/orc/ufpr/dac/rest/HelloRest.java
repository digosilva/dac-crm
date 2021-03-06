package orc.ufpr.dac.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloRest {

	private final static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(
			@RequestParam(value="name", required=false, defaultValue="World")
			String name) {
		
		return new HttpEntity<Greeting>(new Greeting(counter.incrementAndGet(), String.format(template, name)));
	}
	
}
