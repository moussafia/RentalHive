package ma.youcode.rentalhive.model.domaine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity @Data  @NoArgsConstructor @AllArgsConstructor
@Builder

public class DossierReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Reservation reservation;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private EquipmentMatricule equipmentMatricule;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Float price;
}
