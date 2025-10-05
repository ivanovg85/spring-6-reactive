package art.cookedincode.spring6reactive.mappers;

import art.cookedincode.spring6reactive.domain.Beer;
import art.cookedincode.spring6reactive.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * Created by Georgi Ivanov
 */
@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
