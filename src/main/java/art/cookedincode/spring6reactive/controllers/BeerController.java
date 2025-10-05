package art.cookedincode.spring6reactive.controllers;

import art.cookedincode.spring6reactive.model.BeerDTO;
import art.cookedincode.spring6reactive.services.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Georgi Ivanov
 */
@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    public static final String BEER_PATH = "/api/v2/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    @PostMapping(BEER_PATH)
    Mono<ResponseEntity<Void>> createNewBeer(@RequestBody @Validated BeerDTO beerDTO) {
        return beerService.saveNewBeer(beerDTO)
                .map(savedDto -> ResponseEntity.created(
                        UriComponentsBuilder
                                .fromUriString("http://localhost:8080/" + BEER_PATH + "/" + savedDto.getId())
                                .build().toUri()
                        ).build()
                );
    }

    @PutMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> updateExistingBeer(@PathVariable Integer beerId, @RequestBody @Validated BeerDTO beerDTO) {
        return beerService.updateBeer(beerId, beerDTO).map(_ -> ResponseEntity.noContent().build());
    }

    @PatchMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> patchBeer(@PathVariable Integer beerId, @RequestBody @Validated BeerDTO beerDTO) {
        return beerService.patchBeer(beerId, beerDTO).map(_ -> ResponseEntity.noContent().build());
    }

    @GetMapping(BEER_PATH_ID)
    Mono<BeerDTO> getBeerById(@PathVariable Integer beerId) {
        return beerService.getBeerById(beerId);
    }

    @GetMapping(BEER_PATH)
    Flux<BeerDTO> listBeers() {
        return beerService.listBeers();
    }

    @DeleteMapping(BEER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteBeerById(@PathVariable Integer beerId) {
        return beerService.deleteBeerById(beerId).thenReturn(ResponseEntity.noContent().build());
    }
}
