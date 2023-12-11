package ma.youcode.rentalhive.model.mapper.equipmentDtoMapper;

import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentPostDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentResponseDto;
import ma.youcode.rentalhive.model.mapper.categoryDtoMapper.CategoryDtoMapper;

public class EquipmentDtoMapper {
    public static EquipmentResponseDto toEquipmentDto(Equipment equipment){
        CategoryDto categoryDto = CategoryDtoMapper.toCategoryDto(equipment.getCategory());
        EquipmentResponseDto equipmentResponseDto = new EquipmentResponseDto(
                equipment.getId(),
                equipment.getName(),
                equipment.getQuantity(),
                equipment.getPricePerDay(),
                equipment.getManufacturer().getManufacturer(),
                categoryDto
        );
        return equipmentResponseDto;
    }
    public static Equipment toEquipment(EquipmentPostDto equipmentPostDto){
        Manufacturer manufacturer = Manufacturer.builder().manufacturer(equipmentPostDto.manufacturerName()).build();
        Equipment equipment = new Equipment().builder()
                .id(equipmentPostDto.id())
                .quantity(equipmentPostDto.quantity())
                .name(equipmentPostDto.name())
                .category(new Category().builder().id(equipmentPostDto.categoryId()).build())
                .manufacturer(manufacturer)
                .pricePerDay(equipmentPostDto.pricePerDay())
                .build();
        return equipment;
    }
}
