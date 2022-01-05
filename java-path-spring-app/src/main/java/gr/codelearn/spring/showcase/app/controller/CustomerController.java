package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesPerCustomerCategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * import java.util.List; This class represents a controller responsible of accepting requests targeting {@link
 * Customer}.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController extends AbstractController<Customer> {
	private final CustomerService customerService;

	@Override
	public BaseService<Customer, Long> getBaseService() {
		return customerService;
	}

	@GetMapping(params = {"email"})
	public ResponseEntity<ApiResponse<Customer>> findByEmail(@RequestParam String email) {
		return ResponseEntity.ok(ApiResponse.<Customer>builder().data(customerService.findByEmail(email)).build());
	}

	@GetMapping(headers = "action=customersPurchasedMostExpensiveProduct")
	public ResponseEntity<ApiResponse<List<KeyValue<String, Long>>>> findCustomersPurchasedMostExpensiveProduct() {
		final List<KeyValue<String, Long>> customersPurchasedMostExpensiveProductList = customerService.findCustomersPurchasedMostExpensiveProduct();
		return ResponseEntity.ok(
				ApiResponse.<List<KeyValue<String, Long>>>builder().data(customersPurchasedMostExpensiveProductList)
						   .build());
	}

	@GetMapping(headers = "action=totalNumberAndCostOfPurchasesPerCustomerCategory")
	public ResponseEntity<ApiResponse<List<PurchasesPerCustomerCategoryDto>>> findTotalNumberAndCostOfPurchasesPerCustomerCategory() {
		final List<PurchasesPerCustomerCategoryDto> purchasesPerCustomerCategoryList = customerService.findTotalNumberAndCostOfPurchasesPerCustomerCategory();
		return ResponseEntity.ok(
				ApiResponse.<List<PurchasesPerCustomerCategoryDto>>builder().data(purchasesPerCustomerCategoryList)
						   .build());
	}
}
