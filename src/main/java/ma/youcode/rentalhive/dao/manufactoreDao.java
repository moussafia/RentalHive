package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Manufactorer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface manufactoreDao extends JpaRepository<Manufactorer, Long> {
}
