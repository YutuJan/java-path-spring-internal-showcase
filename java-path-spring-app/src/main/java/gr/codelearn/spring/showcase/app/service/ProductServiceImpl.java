package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import gr.codelearn.spring.showcase.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public BaseRepository<Product, Long> getRepository() {
		return productRepository;
	}
}
