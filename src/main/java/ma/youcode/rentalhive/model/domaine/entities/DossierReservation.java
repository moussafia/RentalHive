package ma.youcode.rentalhive.model.domaine.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity @Data  @NoArgsConstructor @AllArgsConstructor
@Builder
public class DossierReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    @ManyToOne
    private EquipmentMatricule equipmentMatricule;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float price;
}
