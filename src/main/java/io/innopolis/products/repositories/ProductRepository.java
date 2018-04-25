package io.innopolis.products.repositories;

import io.innopolis.products.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}