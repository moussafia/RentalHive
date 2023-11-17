package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufactorer;

import java.time.LocalDateTime;
import java.util.List;

public interface EquipmentService {

    Equipment createEquipment(Equipment equipment,
                                       Category category,
                                       Manufactorer manufactorer);
    Equipment updateEquipment(Equipment equipment,
                              Category category,
                              Manufactorer manufactorer);
    List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                              LocalDateTime dateTime);


}
