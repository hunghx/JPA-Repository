package rikkei.academy.service.country;

import rikkei.academy.model.Country;
import rikkei.academy.service.IGenericService;

public interface ICountryService extends IGenericService<Country,Long> {
    Iterable<Country> findAll();
}
