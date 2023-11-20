package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Long id, Equipment equipment);
    List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                              LocalDateTime dateTime);
    Optional<Equipment> checkEquipmentIfExist(String name);
    Optional<Category> checkCategoryIfExistForCreateEquipment(Long category_id);


    void validateEquipment();
    Optional<Manufacturer> fetshOrCreateEquipmentManufactorer(String manufactorer);

    Optional<Equipment> checkEquipmentIfExistById(long equipmentId);
}
