package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Simple class representing bean depending on another bean.
 */
@Component
@DependsOn("independentBean")
public class DependentBean extends AbstractLogComponent {
	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am a dependent bean.");
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be a dependent bean.");
	}
}
