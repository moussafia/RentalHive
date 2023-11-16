package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.entities.Manufactorer;

public interface EquipmentCrudService {
    EquipmentMatricule createEquipment(EquipmentMatricule matricule,
                                       Equipment equipment,
                                       Category category,
                                       Manufactorer manufactorer);
    EquipmentMatricule updateEquipment(EquipmentMatricule Equipment);
    EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment);
    EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment);

}
