package ma.youcode.rentalhive.dto;

import lombok.*;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.entities.Manufacturer;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Equipment}
 */
@Value @Data
public class EquipmentDto implements Serializable {
    @PositiveOrZero
    Long id;
    @NotNull(message = "name should not be null")
    @Pattern(regexp = "[a-zA-Z]+")
    @NotEmpty(message = "name should not be empty")
    @NotBlank(message = "name should not be blank")
    String name;
    @PositiveOrZero
    Integer quantity;
    @NotNull
    Float pricePerDay;
    Manufacturer manufacturer;
    @Getter
    Set<EquipmentMatricule> equipmentMatricule;
    Category category;
    public void setEquipmentMatricule(EquipmentMatricule equipmentMatricule) {
        this.equipmentMatricule.add(equipmentMatricule);
    }
}