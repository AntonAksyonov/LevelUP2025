package homework21.impl;

import homework21.interfaces.CityDao;
import homework21.HibernateHelper;
import homework21.model.City;

import java.util.List;
import java.util.Optional;

public class CityJpaDaoImpl implements CityDao {

    @Override
    public List<City> findAll() {
        return HibernateHelper.runInTransaction(entityManager -> {
            return entityManager.createQuery("select city from City city").getResultList();
        });
    }

    @Override
    public Optional<City> findByCode(String code) {
        return HibernateHelper.runInTransaction(entityManager -> {
            return entityManager.createQuery(
                            "select city from City city where city.code = :code"
                    )
                    .setParameter("code", code)
                    .getResultList()
                    .stream()
                    .findFirst();
        });
    }

    @Override
    public void save(City city) {
        HibernateHelper.runInTransaction(entityManager -> {
            if (city.getId() != null) {
                entityManager.merge(city);
            } else {
                entityManager.persist(city);
            }
        });
    }

    @Override
    public void delete(City city) {
        HibernateHelper.runInTransaction(session -> {
            session.remove(city);
        });
    }
}
