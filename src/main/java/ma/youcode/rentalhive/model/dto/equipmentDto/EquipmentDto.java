package ma.youcode.rentalhive.model.dto.equipmentDto;

import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;

import java.io.Serializable;

public record EquipmentDto(
        Long id,
        String name,
        Integer quantity,
        Float pricePerDay,
        String manufacturerName,
        CategoryDto category) implements Serializable {
}