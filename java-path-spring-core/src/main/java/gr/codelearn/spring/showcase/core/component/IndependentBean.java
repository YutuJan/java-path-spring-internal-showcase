package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Simple class representing bean upon which another beans depend on.
 */
@Component
public class IndependentBean extends AbstractLogComponent {
	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am an independent bean.");
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be an independent bean.");
	}
}
