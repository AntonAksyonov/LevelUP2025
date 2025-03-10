package homework21.interfaces;


import homework21.model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {

    List<City> findAll();

    Optional<City> findByCode(String code);

    void save(City city);

    void delete(City city);
}
