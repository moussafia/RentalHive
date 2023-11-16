package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufactorer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EquipmentService {

    Equipment createEquipment(Equipment equipment,
                                       Long category_id,
                                       String manufactorer);
    Equipment updateEquipment(Equipment equipment,
                              Category category,
                              Manufactorer manufactorer);
    List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                              LocalDateTime dateTime);
    Optional<Equipment> checkEquipmentIfExist(String name);
    Optional<Category> checkCategoryIfExistForCreateEquipment(Long category_id);


    void validateEquipment();
    Optional<Manufactorer> fetshOrCreateEquipmentManufactorer(String manufactorer);


}
