package gr.codelearn.spring.showcase.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * This class holds all common attributes a category in which products are organized.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
	private Long id;
}
