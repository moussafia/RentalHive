package ma.youcode.rentalhive.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @ToString(exclude = {"manufacturer","category", "equipmentMatricule"}) @EqualsAndHashCode(exclude = {"manufacturer","category", "equipmentMatricule"})
public class Equipment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name should not be null")
    @Pattern(regexp = "[a-zA-Z]+")
    private String name;
   @Positive
    private Integer quantity;
   @PositiveOrZero
    private Float pricePerDay;
    @ManyToOne
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "equipment")
    @JsonManagedReference
    private Set<EquipmentMatricule> equipmentMatricule;
    @ManyToOne
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;


}
