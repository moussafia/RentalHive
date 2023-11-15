package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDao extends JpaRepository<Equipment, Long> {
}
