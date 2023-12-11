package ma.youcode.rentalhive.model.dto.equipmentDto;

import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
public record EquipmentPostDto(
        Long id,
        String name,
        Integer quantity,
        Float pricePerDay,
        String manufacturerName,
        Long categoryId) implements Serializable {
}
