package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentDto;
import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;

import java.time.LocalDateTime;
import java.util.List;


public interface EquipmentService {

    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Long id, EquipmentDto equipmentDto);

    List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                              LocalDateTime dateTime);
    void checkEquipmentIfExist(String name);
    Category checkCategoryIfExistForCreateEquipment(Long category_id);

    Manufacturer fetshOrCreateEquipmentManufactorer(String manufactorer);

    void validateEquipment(Equipment equipment);

    void validateEquipment();

}