package gr.codelearn.spring.showcase.app.domain;

/**
 * This enumeration class represents all customer categories.
 */
public enum CustomerCategory {
	INDIVIDUAL(0), BUSINESS(0.2f), GOVERNMENT(0.5f);

	private final float discount;

	CustomerCategory(float discount) {
		this.discount = discount;
	}

	public float getDiscount() {
		return this.discount;
	}
}
