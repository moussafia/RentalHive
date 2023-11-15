package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratDao extends JpaRepository<Contract, Long> {
}
