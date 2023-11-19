package ma.youcode.rentalhive.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Manufacturer manufacturer;
    @OneToMany(mappedBy = "equipment")
    private Set<EquipmentMatricule> equipmentMatricule;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;


}
