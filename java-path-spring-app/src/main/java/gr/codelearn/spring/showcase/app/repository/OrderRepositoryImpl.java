package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl extends AbstractRepository<Order> implements OrderRepository {
	List<Order> orderStorage = new ArrayList<>();

	@Override
	public List<Order> getStorage() {
		return orderStorage;
	}
}
