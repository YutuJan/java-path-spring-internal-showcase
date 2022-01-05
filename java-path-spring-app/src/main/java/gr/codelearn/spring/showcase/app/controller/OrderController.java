package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents a controller responsible of accepting requests targeting {@link Order}. For more info about
 * versioning that the reader will see in this class, follow this link: https://www.springboottutorial.com/spring-boot-versioning-for-rest-services
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController extends AbstractController<Order> {
	private final OrderService orderService;

	@Override
	public BaseService<Order, Long> getBaseService() {
		return orderService;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Order>> get(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(ApiResponse.<Order>builder().data(orderService.getLazy(id)).build());
	}

	@Override
	@GetMapping
	public ResponseEntity<ApiResponse<List<Order>>> findAll() {
		return ResponseEntity.ok(ApiResponse.<List<Order>>builder().data(orderService.findAllLazy()).build());
	}

	@GetMapping(path = "v1", headers = "action=averageOrderCostPerCustomer")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV1() {
		final var results = orderService.findAverageOrderCostPerCustomer();
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder().data(results).build());
	}

	@GetMapping(path = "v2", headers = "action=averageOrderCostPerCustomer")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerV2() {
		final var results = orderService.findAverageOrderCostPerCustomer();

		return ResponseEntity.ok(
				ApiResponse.<List<KeyValue<String, BigDecimal>>>builder().data(generateSublist(results)).build());
	}

	@GetMapping(headers = "action=averageOrderCostPerCustomer")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerHeader(
			@RequestHeader(value = "api-version", defaultValue = "1") Integer version) {
		var results = orderService.findAverageOrderCostPerCustomer();

		if (version == 2) {
			results = generateSublist(results);
		}
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder().data(results).build());
	}

	@GetMapping(headers = "action=averageOrderCostPerCustomer", params = "version")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerParam(
			@RequestParam Integer version) {
		var results = orderService.findAverageOrderCostPerCustomer();
		if (version == 2) {
			results = generateSublist(results);
		}
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder().data(results).build());
	}

	@GetMapping(headers = "action=averageOrderCostPerCustomer", produces = "application/vnd.app-v1+json")
	public ResponseEntity<ApiResponse<List<KeyValue<String, BigDecimal>>>> findAverageOrderCostPerCustomerAcceptHeader() {
		final List<KeyValue<String, BigDecimal>> results = orderService.findAverageOrderCostPerCustomer();
		return ResponseEntity.ok(ApiResponse.<List<KeyValue<String, BigDecimal>>>builder().data(results).build());
	}

	private static List<KeyValue<String, BigDecimal>> generateSublist(List<KeyValue<String, BigDecimal>> list) {
		// Simple method to showcase versioning. It sorts a list based on value and returns top 5 entries.
		if (list.size() >= 5) {
			list.sort(Comparator.comparing(KeyValue::getValue));
		}
		// Returns the last five elements (as they are the ones with the largest values)
		return list.subList(list.size() - 5, list.size());
	}
}
