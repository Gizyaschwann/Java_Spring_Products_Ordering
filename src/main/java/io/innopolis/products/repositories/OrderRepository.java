package io.innopolis.products.repositories;

import io.innopolis.products.models.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * No need to declare methods in these and furher classes - everything is done in CrudRepository
 *
 */
public interface OrderRepository extends CrudRepository<CustomerOrder,Long> {

}