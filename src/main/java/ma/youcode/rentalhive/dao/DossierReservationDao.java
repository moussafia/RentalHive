package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface DossierReservationDao extends JpaRepository<DossierReservation, Long> {

    @Query("SELECT (em.id) FROM EquipmentMatricule em " +
            "where  em.equipment.id = :equipmentId " +
            "AND em.id NOT IN " +
            "( " +
            "SELECT (dr.equipmentMatricule.id) " +
            "FROM DossierReservation as dr " +
            " " +
            "JOIN Reservation as r " +
            "on r.id = dr.reservation.id " +
            "JOIN Contract as c " +
            "on dr.reservation.id = c.reservation.id " +
            "WHERE dr.equipmentMatricule.id = em.id " +
            "AND (c.statusAdmin =  'FULFILLED' or (c.statusAdmin = 'PENDING' AND r.user.id = :userID)) " +
            "AND (r.statusClient =  'FULFILLED' or (r.statusClient= 'PENDING' AND r.user.id = :userID)) " +
            "AND ( " +
            "CASE " +
            "WHEN dr.startDate >  :startdate " +
            "AND dr.endDate >  :enddate AND dr.startDate <  :enddate THEN 1 " +
            "WHEN dr.startDate <  :startdate " +
            "AND dr.endDate >  :enddate THEN 1 " +
            "WHEN dr.endDate >  :startdate " +
            "AND dr.endDate <  :enddate THEN 1 " +
            "END " +
            ") " +
            ")")
    Set<Long> countQuantityAvailableForEquipment(@Param("equipmentId") Long equipmentId,
                                                        @Param("userID") Long userID,
                                                        @Param("startdate") LocalDateTime startdate,
                                                        @Param("enddate") LocalDateTime enddate,
                                                        Pageable pageable);
}
