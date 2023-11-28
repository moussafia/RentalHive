package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.model.domaine.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {
}
