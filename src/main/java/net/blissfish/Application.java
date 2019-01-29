package net.blissfish;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private static final String HELLO_MSG = "Hello v2.0.0";
	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);
	
	@PostConstruct
	public void logSomething() {
		logger.debug("Sample Debug Message");
		logger.trace("Sample Trace Message");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/hello")
    public String getHello() {
    	logger.debug("Returning ["+HELLO_MSG+"]");
        return HELLO_MSG;
    }
    
}