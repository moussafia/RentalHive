package ma.youcode.rentalhive.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EquipmentMatricule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricule;
    @ManyToOne
    private Equipment equipment;
    @ManyToMany
    @JoinTable(
            name = "demande_eqmatricules",
            joinColumns = @JoinColumn(name = "Equipmentmatricule_id"),
            inverseJoinColumns = @JoinColumn(name = "demande_id")
    )
    private Set<Contract> contracts;

}
