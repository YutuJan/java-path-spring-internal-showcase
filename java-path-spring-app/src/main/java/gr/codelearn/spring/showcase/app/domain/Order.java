package gr.codelearn.spring.showcase.app.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Delegate;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents an order submitted by a customer.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ORDERS", indexes = {@Index(columnList = "customer_id")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseEntity {
	private interface MinimalSet {
		boolean add(OrderItem item);

		boolean remove(OrderItem item);
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date submitDate;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Delegate(types = MinimalSet.class)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
	private final Set<OrderItem> orderItems = new HashSet<>();

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentMethod paymentMethod;

	@NotNull
	@Column(precision = 10, scale = 2, nullable = false)
	private BigDecimal cost;
}
