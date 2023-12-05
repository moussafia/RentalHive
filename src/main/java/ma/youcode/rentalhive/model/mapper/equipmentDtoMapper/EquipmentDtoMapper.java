package ma.youcode.rentalhive.model.mapper.equipmentDtoMapper;

import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentDto;
import ma.youcode.rentalhive.model.mapper.categoryDtoMapper.CategoryDtoMapper;

public class EquipmentDtoMapper {
    public static EquipmentDto toEquipmentDto(Equipment equipment){
        CategoryDto categoryDto = CategoryDtoMapper.toCategoryDto(equipment.getCategory());
        EquipmentDto equipmentDto = new EquipmentDto(
                equipment.getId(),
                equipment.getName(),
                equipment.getQuantity(),
                equipment.getPricePerDay(),
                equipment.getManufacturer().getManufacturer(),
                categoryDto
        );
        return equipmentDto;
    }
    public static Equipment toEquipment(EquipmentDto equipmentDto){
        Category category = CategoryDtoMapper.toCategory(equipmentDto.category());
        Manufacturer manufacturer = Manufacturer.builder().manufacturer(equipmentDto.manufacturerName()).build();
        Equipment equipment = new Equipment().builder()
                .id(equipmentDto.id())
                .quantity(equipmentDto.quantity())
                .name(equipmentDto.name())
                .category(category)
                .manufacturer(manufacturer)
                .pricePerDay(equipmentDto.pricePerDay())
                .build();
        return equipment;
    }
}
