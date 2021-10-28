package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * This class holds all common attributes a category in which products are organized.
 */
@Data
@SuperBuilder
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
}
