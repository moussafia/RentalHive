package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Long id, Equipment equipment);
    List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                              LocalDateTime dateTime);
    void checkEquipmentIfExist(String name);
    Category checkCategoryIfExistForCreateEquipment(Long category_id);

    Manufacturer fetshOrCreateEquipmentManufactorer(String manufactorer);

    void validateEquipment(Equipment equipment);

    void validateEquipment();

    Optional<Equipment> checkEquipmentIfExistById(long equipmentId);
}
