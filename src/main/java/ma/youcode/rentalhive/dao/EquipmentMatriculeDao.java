package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentMatriculeDao extends JpaRepository<EquipmentMatricule, Long> {
    @Override
    Optional<EquipmentMatricule> findById(Long aLong);
}
