package rikkei.academy.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rikkei.academy.dao.ICountryRepository;
import rikkei.academy.model.Country;

import java.util.Optional;
@Service
public class CountryService implements ICountryService{
    @Autowired
    private ICountryRepository countryRepository;
    @Override
    public Page<Country> findAll(Pageable pageable, Sort sort) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }
}
