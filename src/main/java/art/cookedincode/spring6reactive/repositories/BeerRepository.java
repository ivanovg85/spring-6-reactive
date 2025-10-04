package art.cookedincode.spring6reactive.repositories;

import art.cookedincode.spring6reactive.domain.Beer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created by Georgi Ivanov
 */
public interface BeerRepository extends ReactiveCrudRepository<Beer, Integer> {
}
