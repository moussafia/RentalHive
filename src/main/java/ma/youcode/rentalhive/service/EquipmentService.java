package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentResponseDto;
import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;


public interface EquipmentService {

    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Long id, EquipmentResponseDto equipmentResponseDto);
    Page<Equipment> fetchAllEquipment(Pageable pageable);

    List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                              LocalDateTime dateTime);
    void checkEquipmentIfExist(String name);
    Category checkCategoryIfExistForCreateEquipment(Long category_id);

    Manufacturer fetshOrCreateEquipmentManufactorer(String manufactorer);

    void validateEquipment(Equipment equipment);

    void validateEquipment();

}