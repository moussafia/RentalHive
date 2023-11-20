package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findByName(String equipment_name);
}