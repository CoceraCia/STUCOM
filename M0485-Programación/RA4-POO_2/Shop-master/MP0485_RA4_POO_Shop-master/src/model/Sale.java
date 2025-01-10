package model;

public class Sale {
	String client;
	Product[] products;
	Amount amount;

	public Sale(String client, Product[] products, Amount amount) {
		super();
		this.client = client;
		this.products = products;
		this.amount = amount;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
                                   String productos = "";
                                   for (Product pr: products){
                                       productos += pr.getName()+", ";
                                   }
		return "Sale [client=" + client + ", products=" + productos + "amount=" + amount.showAmount() + "]";
	}

}