package ma.youcode.rentalhive.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.rentalhive.entities.enums.Status;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Float price;
    @ManyToMany(mappedBy ="contracts")
    private Set<EquipmentMatricule> equipmentMatricules;
    @OneToOne
    @JsonBackReference
    private Demande demande;
}
