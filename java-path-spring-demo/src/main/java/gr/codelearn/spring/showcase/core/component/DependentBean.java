package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.AbstractLogComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Simple class representing bean depending on another bean.
 */
@Component
@RequiredArgsConstructor
public class DependentBean extends AbstractLogComponent {
	private final IndependentBean independentBean;

	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am a dependent bean and here's a hello from independent bean: {}",
					independentBean.sayHi());
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be a dependent bean.");
	}
}
