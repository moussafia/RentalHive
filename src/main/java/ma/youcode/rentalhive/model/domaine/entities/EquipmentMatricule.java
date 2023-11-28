package ma.youcode.rentalhive.model.domaine.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "equipmentmatricule")
public class EquipmentMatricule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    @ManyToOne
    @JsonBackReference
    private Equipment equipment;
    @OneToMany(mappedBy = "equipmentMatricule")
    Set<DossierReservation> dossierReservations;

}
