package ma.youcode.rentalhive.model.dto.equipmentDto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data @Builder
public class EquipmentDto implements Serializable {
    Long id;
    String name;
    Integer quantity;
    Float pricePerDay;
    String manufacturerName;
    Long category_id;
    Integer quantity_available;
}