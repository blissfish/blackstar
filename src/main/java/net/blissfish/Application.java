package net.blissfish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);

	@PostConstruct
	public void logSomething() {
		logger.debug("Sample Debug Message");
		logger.trace("Sample Trace Message");
		logger.info("Sample Info Message");
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/hello")
    public String getHello() {
    	logger.info("Returning [Hello World!]");
    	logger.debug("Returning [Hello World!]");

    	return 	"Hello World!";
    }

	@RequestMapping("/")
	public String echo(@RequestParam Map<String,String> allParams) {
		return "Echo: " + allParams.entrySet();
	}
}