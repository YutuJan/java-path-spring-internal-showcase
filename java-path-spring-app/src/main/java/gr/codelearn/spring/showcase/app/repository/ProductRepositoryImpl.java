package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl extends AbstractRepository<Product> implements ProductRepository {
	List<Product> productStorage = new ArrayList<>();

	@Override
	public List<Product> getStorage() {
		return productStorage;
	}
}
