package ma.youcode.rentalhive.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Float pricePerDay;
    @ManyToOne
    private Manufactorer manufactorer;
    @OneToMany(mappedBy = "equipment")
    private Collection<EquipmentMatricule> equipmentMatricule;
    @ManyToOne
    private Category category;
}
