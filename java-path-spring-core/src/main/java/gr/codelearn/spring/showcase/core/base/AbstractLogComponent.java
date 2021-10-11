package gr.codelearn.spring.showcase.core.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * Abstract class used to provide logging functionality to all components.
 */
public abstract class AbstractLogComponent {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@PostConstruct
	private void init() {
		logger.trace("Loaded {}.", getClass().getName());
	}
}
