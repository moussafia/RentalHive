package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;

public interface EquipmentCrudService {
    EquipmentMatricule createEquipment(EquipmentMatricule Equipment);

    EquipmentMatricule updateEquipment(Long id, EquipmentMatricule equipment);

    EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment);
    EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment);

}
