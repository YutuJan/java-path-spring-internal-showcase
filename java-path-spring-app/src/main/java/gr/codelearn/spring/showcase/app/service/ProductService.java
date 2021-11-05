package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, Long> {
	List<Product> findAllLazy();

	Product findBySerial(String serial);
}
