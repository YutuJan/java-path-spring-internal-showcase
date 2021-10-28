package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a customer to our eshop system.
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {
	private String email;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	private CustomerCategory customerCategory;
}
