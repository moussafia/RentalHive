package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Manufactorer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactoreDao extends JpaRepository<Manufactorer, Long> {
}
