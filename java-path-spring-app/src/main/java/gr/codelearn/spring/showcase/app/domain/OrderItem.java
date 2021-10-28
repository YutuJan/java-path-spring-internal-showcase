package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * This class represents an order item, a product that is part an order submitted by a customer.
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends BaseEntity {
	private Product product;
	private Integer quantity;
	private BigDecimal price;
}
