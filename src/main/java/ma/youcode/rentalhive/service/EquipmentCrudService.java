package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;

public interface EquipmentCrudService {
    EquipmentMatricule createEquipment(EquipmentMatricule Equipment);
    Equipment updateEquipment(Equipment Equipment);
    EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment);
    EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment);

}
