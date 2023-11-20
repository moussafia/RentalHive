package ma.youcode.rentalhive.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @ToString(exclude = {"manufacturer","category", "equipmentMatricule"}) @EqualsAndHashCode(exclude = {"manufacturer","category", "equipmentMatricule"})
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Float pricePerDay;
    @ManyToOne
    @JsonBackReference
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "equipment")
    @JsonManagedReference
    private Set<EquipmentMatricule> equipmentMatricule;
    @ManyToOne
    @JsonBackReference
    private Category category;


}
