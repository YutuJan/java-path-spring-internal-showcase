package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * This class represents a customer to our eshop system.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CUSTOMERS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CUSTOMERS_SEQ", initialValue = 1, allocationSize = 1)
public class Customer extends BaseEntity {
	@NotNull(message = "Customer's email should not be empty.")
	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@NotNull(message = "Customer's firstname should be present.")
	@Column(length = 20, nullable = false)
	private String firstname;

	@NotNull(message = "Customer's firstname should be present.")
	@Column(length = 30, nullable = false)
	private String lastname;

	@Min(value = 16, message = "")
	@Max(value = 100, message = "")
	private Integer age;

	@Column(length = 50)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private CustomerCategory customerCategory;
}
