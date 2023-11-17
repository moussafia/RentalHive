package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufactoreDao extends JpaRepository<Manufacturer, Long> {
    Optional<Manufacturer> findByManufactorer(String manufactorer_name);
}
