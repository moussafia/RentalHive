package ma.youcode.rentalhive.model.dto.equipmentDto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data @Builder
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
    Integer quantity_available;
}