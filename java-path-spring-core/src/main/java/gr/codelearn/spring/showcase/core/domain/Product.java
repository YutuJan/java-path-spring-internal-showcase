package gr.codelearn.spring.showcase.core.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
	private final String name;
	private final String serial;
	private final BigDecimal price;
	private final String category;
}
