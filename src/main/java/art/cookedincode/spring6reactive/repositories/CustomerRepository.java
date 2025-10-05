package art.cookedincode.spring6reactive.repositories;

import art.cookedincode.spring6reactive.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created by Georgi Ivanov
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
