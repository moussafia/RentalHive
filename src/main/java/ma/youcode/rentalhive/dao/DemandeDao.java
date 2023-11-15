package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeDao extends JpaRepository<Demande, Long> {
}
