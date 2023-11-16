package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, Long> {
}
