package com.telusko.ProductSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);

		ProductService service =context.getBean(ProductService.class);




		// Adding products to the service
		service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
		service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
		service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
		service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
		service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
		service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
		service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
		service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
		service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
		service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
		service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
		service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
		service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
		service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
		service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));

// Get a product by name
		Product product = service.getProductByName("Mac Studio");
		if (product != null) {
			System.out.println("Product found: " + product);
		} else {
			System.out.println("Product not found.");
		}

// Get products out of warranty
		List<Product> outOfWarrantyProducts = service.getOutOfWarrantyProducts();
		System.out.println("Out of warranty products:");
		for (Product p : outOfWarrantyProducts) {
			System.out.println(p);
		}

// Get products by place with matching text
		String searchText = "Table";
		List<Product> productsByPlace = service.getProductsByPlace(searchText);
		System.out.println("Products found for place containing '" + searchText + "':");
		for (Product p : productsByPlace) {
			System.out.println(p);
		}

	}

}
