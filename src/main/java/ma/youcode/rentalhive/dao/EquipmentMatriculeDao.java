package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.EquipmentMatricule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentMatriculeDao extends JpaRepository<EquipmentMatricule, Long> {
}
