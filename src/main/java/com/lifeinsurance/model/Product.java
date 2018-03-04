package com.lifeinsurance.model;

public class Product {

	private long id;
	private String title;
	private String description;
	private String category;
	private int price;

	public Product() {
	}

	public Product(long id, String title, String description, String category, int price) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
