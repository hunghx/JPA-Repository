package rikkei.academy.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rikkei.academy.model.Country;
import rikkei.academy.service.country.ICountryService;

import java.util.Optional;
@Component
public class CountryConverter implements Converter<String, Country> {
    private ICountryService countryService;
    @Autowired
    public CountryConverter(ICountryService countryService){
        this.countryService = countryService;
    }
    @Override
    public Country convert(String source) {
        Optional<Country> optionalCountry = countryService.findById(Long.valueOf(source));
        return optionalCountry.orElse(null);
    }
}
