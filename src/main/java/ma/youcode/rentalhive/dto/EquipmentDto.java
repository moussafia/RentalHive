package ma.youcode.rentalhive.dto;

import lombok.*;
import ma.youcode.rentalhive.entities.Equipment;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * DTO for {@link Equipment}
 */
@Value @Data
public class EquipmentDto implements Serializable {
    @PositiveOrZero
    Long id;
    @Pattern(regexp = "[a-zA-Z]+")
    String name;
    @PositiveOrZero
    Integer quantity;
    @PositiveOrZero
    Float pricePerDay;
    @Pattern(regexp = "[a-zA-Z]+")
    String manufacturerName;
    @Positive
    Long category_id;
}