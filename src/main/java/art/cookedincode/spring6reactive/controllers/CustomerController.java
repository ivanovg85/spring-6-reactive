package art.cookedincode.spring6reactive.controllers;

import art.cookedincode.spring6reactive.model.CustomerDTO;
import art.cookedincode.spring6reactive.services.CustomerService;
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
public class CustomerController {

    public static final String CUSTOMER_PATH = "/api/v2/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    private final CustomerService customerService;

    @PostMapping(CUSTOMER_PATH)
    Mono<ResponseEntity<CustomerDTO>> createCustomer(@RequestBody @Validated CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO)
                .map(createdCustomer -> ResponseEntity.created(UriComponentsBuilder
                        .fromUriString("http://localhost:8080" + CUSTOMER_PATH_ID).buildAndExpand(createdCustomer.getId()).toUri()
                ).build());
    }

    @PutMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> updateCustomer(@PathVariable Integer customerId, @RequestBody @Validated CustomerDTO customerDTO) {
        return customerService.updateCustomer(customerId, customerDTO).map(_ -> ResponseEntity.noContent().build());
    }

    @PatchMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> patchCustomer(@PathVariable Integer customerId, @RequestBody @Validated CustomerDTO customerDTO) {
        return customerService.patchCustomer(customerId, customerDTO).map(_ -> ResponseEntity.noContent().build());
    }

    @GetMapping(CUSTOMER_PATH_ID)
    Mono<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(CUSTOMER_PATH)
    Flux<CustomerDTO> listCustomers() {
        return customerService.listCustomers();
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    Mono<ResponseEntity<Void>> deleteCustomerById(@PathVariable Integer customerId) {
        return customerService.deleteCustomerById(customerId).thenReturn(ResponseEntity.noContent().build());
    }
}
