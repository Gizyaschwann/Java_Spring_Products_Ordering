package io.innopolis.products;

import io.innopolis.products.models.Product;
import io.innopolis.products.repositories.OrderRepository;
import io.innopolis.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication implements CommandLineRunner {

	@Autowired
    ProductRepository productRepository;

	@Autowired
    OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {

        Product apple = new Product();
        apple.setProductName("Apple");
        apple.setProductPrice(67.95);

        Product lemon = new Product();
        lemon.setProductName("Lemon");
        lemon.setProductPrice(120.95);

        Product bread = new Product();
        bread.setProductName("Bread");
        bread.setProductPrice(120.95);

        productRepository.save(apple);
        productRepository.save(lemon);
        productRepository.save(bread);

    }
}
