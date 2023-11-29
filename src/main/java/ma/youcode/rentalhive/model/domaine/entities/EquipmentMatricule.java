package ma.youcode.rentalhive.model.domaine.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "equipmentmatricule")
@ToString(exclude = "dossierReservations")
public class EquipmentMatricule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    @ManyToOne
    //@JsonBackReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Equipment equipment;
    @OneToMany(mappedBy = "equipmentMatricule")
    private Set<DossierReservation> dossierReservations;

}
