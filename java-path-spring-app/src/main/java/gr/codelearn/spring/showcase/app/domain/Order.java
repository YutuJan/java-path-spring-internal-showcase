package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents an order submitted by a customer.
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseEntity {
	private Customer customer;
	private Date submitDate;
	private final Set<OrderItem> orderItems = new HashSet<>();
	private PaymentMethod paymentMethod;
	private BigDecimal cost;
}
