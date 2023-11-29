package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.EquipmentMatricule;

import java.util.List;

public interface EquipmentMatriculesService {
    Equipment saveEquipmentMatricule(Equipment equipment);
    EquipmentMatricule findEqupmentMatriculeById(Long id);

    EquipmentMatricule updateEquipmentMatricule(Long id, EquipmentMatricule equipment);

    EquipmentMatricule updateEquipmentMatricule(Equipment equipment);

    void deleteEquipemntMatricule(EquipmentMatricule equipmentMatricule);
    List<EquipmentMatricule> ShowAllEquipmentMatricule();
    EquipmentMatricule searchEquipementMatricule(EquipmentMatricule equipmentMatricule);
    EquipmentMatricule historicForEquipment(EquipmentMatricule matricule);
    void validateEquipmentMatricule(EquipmentMatricule matricule);


}
