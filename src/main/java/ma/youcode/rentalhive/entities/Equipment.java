package ma.youcode.rentalhive.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Float pricePerDay;
    @ManyToOne
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "equipment")
    private Set<EquipmentMatricule> equipmentMatricule;
    @ManyToOne
    private Category category;


}
