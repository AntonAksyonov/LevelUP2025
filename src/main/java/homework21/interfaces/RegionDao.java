package homework21.interfaces;

import homework21.model.Region;

import java.util.Optional;

public interface RegionDao {

    Optional<Region> findByCode(String code);

    void save(Region region);
}
