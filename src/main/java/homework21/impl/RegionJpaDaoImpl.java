package homework21.impl;

import homework21.HibernateHelper;
import homework21.interfaces.RegionDao;
import homework21.model.Region;

import java.util.Optional;

public class RegionJpaDaoImpl implements RegionDao {
    @Override
    public Optional<Region> findByCode(String code) {
        return HibernateHelper.runInTransaction(entityManager -> {
            return entityManager.createQuery(
                            "select region from Region region where region.code = :code"
                    )
                    .setParameter("code", code)
                    .getResultList()
                    .stream()
                    .findFirst();
        });
    }

    @Override
    public void save(Region region) {
        HibernateHelper.runInTransaction(entityManager -> {
            if (region.getId() != null) {
                entityManager.merge(region);
            } else {
                entityManager.persist(region);
            }
        });
    }
}
