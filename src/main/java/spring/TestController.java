package spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static final Logger LOG = LogManager.getLogger();

	@GetMapping("public")
	public String publicEndpoint() {
		LOG.info("publicEndpoint");
		return "Hello World";
	}
}
