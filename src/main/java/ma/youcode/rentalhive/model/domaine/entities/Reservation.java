package ma.youcode.rentalhive.model.domaine.entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.rentalhive.model.domaine.enums.Status;

import javax.persistence.*;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Location;
    @ManyToOne
    private User user;
    private Float price;
    @Enumerated(EnumType.STRING)
    private Status statusClient;
    @OneToMany(mappedBy = "reservation")
    private Set<DossierReservation> dossierReservations;
    @OneToOne(mappedBy = "reservation")
    private Contract contractClient;

}
