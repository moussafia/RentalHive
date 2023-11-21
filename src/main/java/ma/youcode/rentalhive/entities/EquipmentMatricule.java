package ma.youcode.rentalhive.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipmentmatricule")
public class EquipmentMatricule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    @ManyToOne
    @JsonBackReference
    private Equipment equipment;
    @ManyToMany
    @JoinTable(
            name = "demande_eqmatricules",
            joinColumns = @JoinColumn(name = "Equipmentmatricule_id"),
            inverseJoinColumns = @JoinColumn(name = "demande_id")
    )
    @JsonManagedReference
    private Set<Contract> contracts;

}
