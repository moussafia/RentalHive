package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.EquipmentMatricule;

public interface EquipmentCrudService {
    EquipmentMatricule createEquipment(EquipmentMatricule Equipment);
    EquipmentMatricule updateEquipment(EquipmentMatricule Equipment);
    EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment);
    EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment);

}
