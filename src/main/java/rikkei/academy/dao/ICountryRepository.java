package rikkei.academy.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Country;

@Repository
public interface ICountryRepository extends PagingAndSortingRepository<Country,Long> {
}
