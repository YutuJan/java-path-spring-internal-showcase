package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("sample-query")
@RequiredArgsConstructor
public class SampleQueryRunner extends AbstractLogComponent implements CommandLineRunner {
	private final OrderService orderService;

	@Override
	public void run(final String... args) throws Exception {
		//		Order order1 = orderService.find(1L);
		// Generates a LazyInitializationException
		// logger.info("Retrieve order {}.", order1);
		//		logger.info("Retrieve order with id {} and total cost {}€.", order1.getId(), order1.getCost());
		//
		//		Order order2 = orderService.getLazy(1L);
		//		logger.info("Retrieve order with id {} and total cost {}€.", order2.getId(), order2.getCost());

		List<Order> orders = orderService.findAll();
		logger.info("Retrieve {} orders.", orders.size());

		logger.info("--------------------------------------------------------");

		List<Order> lazyOrders = orderService.findAllLazy();
		logger.info("Retrieve {} orders.", lazyOrders.size());

		orderService.findAverageOrderCostPerCustomer().forEach(kv -> logger.info("{}:{}", kv.getKey(), kv.getValue()));
		orderService.findTotalNumberAndCostOfPurchasesPerCustomerCategory().forEach(
				p -> logger.info("{}:{}:{}", p.getCategory(), p.getPurchases(), p.getCost()));
	}
}
