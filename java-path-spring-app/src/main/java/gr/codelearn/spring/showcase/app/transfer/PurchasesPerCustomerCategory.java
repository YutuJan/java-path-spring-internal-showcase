package gr.codelearn.spring.showcase.app.transfer;

import java.math.BigDecimal;

public interface PurchasesPerCustomerCategory {
	String getCategory();

	Long getPurchases();

	BigDecimal getCost();
}
