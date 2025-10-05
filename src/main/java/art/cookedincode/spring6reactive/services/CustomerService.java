package art.cookedincode.spring6reactive.services;

import art.cookedincode.spring6reactive.model.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Georgi Ivanov
 */
public interface CustomerService {
    Mono<CustomerDTO> createCustomer(CustomerDTO customerDTO);

    Mono<CustomerDTO> updateCustomer(Integer customerId, CustomerDTO customerDTO);

    Mono<CustomerDTO> patchCustomer(Integer customerId, CustomerDTO customerDTO);

    Mono<CustomerDTO> getCustomerById(Integer customerId);

    Flux<CustomerDTO> listCustomers();

    Mono<Void> deleteCustomerById(Integer customerId);
}
