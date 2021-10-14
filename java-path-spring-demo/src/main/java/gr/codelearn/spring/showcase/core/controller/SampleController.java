package gr.codelearn.spring.showcase.core.controller;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController extends AbstractLogComponent {
	@GetMapping("/")
	public String sayHello() {
		return "Hello from our sample Spring Boot";
	}
}
