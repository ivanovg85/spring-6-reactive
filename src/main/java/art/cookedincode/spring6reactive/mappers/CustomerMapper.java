package art.cookedincode.spring6reactive.mappers;

import art.cookedincode.spring6reactive.domain.Customer;
import art.cookedincode.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * Created by Georgi Ivanov
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDTO(Customer customer);
}
