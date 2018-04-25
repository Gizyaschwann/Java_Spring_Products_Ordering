package io.innopolis.products.repositories;

import io.innopolis.products.models.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder,Long> {

}