package art.cookedincode.spring6reactive.services;

import art.cookedincode.spring6reactive.model.BeerDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Georgi Ivanov
 */
public interface BeerService {

    Mono<BeerDTO> getBeerById(Integer beerId);

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> saveNewBeer(BeerDTO beerDTO);

    Mono<BeerDTO> updateBeer(Integer beerId, BeerDTO beerDTO);

    Mono<BeerDTO> patchBeer(Integer beerId, BeerDTO beerDTO);

    Mono<Void> deleteBeerById(Integer beerId);
}
