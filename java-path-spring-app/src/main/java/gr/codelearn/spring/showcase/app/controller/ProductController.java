package gr.codelearn.spring.showcase.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents a controller responsible of accepting requests targeting {@link Product}.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController extends AbstractController<Product> {
	private final ProductService productService;

	@Override
	public BaseService<Product, Long> getBaseService() {
		return productService;
	}

	@GetMapping(params = {"serial"})
	public ResponseEntity<ApiResponse<Product>> findBySerial(@RequestParam String serial) {
		return ResponseEntity.ok(ApiResponse.<Product>builder().data(productService.findBySerial(serial)).build());
	}

	@GetMapping(params = {"serial"}, headers = "filtered")
	public ResponseEntity<ApiResponse<JsonNode>> findBySerialFiltered(@RequestParam String serial) {
		final Product product = productService.findBySerial(serial);
		return ResponseEntity.ok(
				ApiResponse.<JsonNode>builder().data(filterProductAndConvertToString(product, "price")).build());
	}

	private JsonNode filterProductAndConvertToString(Product product, String... excludedAttributes) {
		/*
		 * Method that filters a given product and returns it based on what attributes we have chosen to exclude
		 * This may be considered a way of dynamic filtering without setting a "global filter" in a product
		 * configuration
		 */
		SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
		FilterProvider filters = simpleFilterProvider.addFilter("product_filter",
																SimpleBeanPropertyFilter.serializeAllExcept(
																		excludedAttributes));

		// Local object mapper that will convert our product to a string based on the given filter
		ObjectMapper mapper = new ObjectMapper();
		mapper.setFilterProvider(filters);
		ObjectWriter writer = mapper.writer();
		final String filteredJsonAsString;
		try {
			// Converting to string to filter out attributes we have excluded
			filteredJsonAsString = writer.writeValueAsString(product);
			return mapper.readTree(filteredJsonAsString);
		} catch (JsonProcessingException e) {
			// Will be caught by the exception handler which handles generic exceptions
			throw new RuntimeException("Json processing has failed");
		}
	}
}
