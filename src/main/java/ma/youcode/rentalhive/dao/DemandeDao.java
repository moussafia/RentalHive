package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDao extends JpaRepository<Demande, Long> {
}
