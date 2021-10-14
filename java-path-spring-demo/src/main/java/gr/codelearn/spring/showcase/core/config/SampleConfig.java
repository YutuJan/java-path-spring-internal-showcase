package gr.codelearn.spring.showcase.core.config;

import gr.codelearn.spring.showcase.core.component.IndependentBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {
	@Bean
	public IndependentBean getIndependentBean() {

		return new IndependentBean();
	}
}
