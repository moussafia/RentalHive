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

    @Query(value ="SELECT (em.id) FROM equipmentmatricule em  " +
            "where  em.equipment_id = :equipmentId  " +
            "AND em.id NOT IN  " +
            "(  " +
            "SELECT (dr.equipment_matricule_id)  " +
            "FROM dossier_reservation as dr  " +
            "  " +
            "JOIN reservation as r  " +
            "on r.id = dr.reservation_id  " +
            "JOIN contract as c  " +
            "on dr.reservation_id = c.reservation_id  " +
            "WHERE dr.equipment_matricule_id = em.id  " +
            "AND (c.status_admin = 'FULFILLED' or (c.status_admin ='PENDING' AND r.user_id = :userID))  " +
            "AND (r.status_client = 'FULFILLED' or (r.status_client='PENDING' AND r.user_id = :userID))  " +
            "AND (  " +
            "CASE  " +
            "WHEN dr.start_date > :startdate  " +
            "AND dr.end_date > :enddate AND dr.start_date < :enddate THEN 1  " +
            "WHEN dr.start_date < :startdate  " +
            "AND dr.end_date > :enddate THEN 1  " +
            "WHEN dr.end_date > :startdate  " +
            "AND dr.end_date < :enddate THEN 1  " +
            "END  " +
            ")  " +
            ") LIMIT :quantityRequested" ,nativeQuery = true)
    Set<Integer> fetshEquipmentAvailable(@Param("equipmentId") Long equipmentId,
                                                        @Param("userID") Long userID,
                                                        @Param("startdate") LocalDateTime startdate,
                                                        @Param("enddate") LocalDateTime enddate,
                                                        @Param("quantityRequested") Integer quantityRequested);
}
