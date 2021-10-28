package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl extends AbstractRepository<Customer> implements CustomerRepository {
	List<Customer> customerStorage = new ArrayList<>();

	@Override
	public List<Customer> getStorage() {
		return customerStorage;
	}
}
