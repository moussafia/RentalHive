package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;

import java.util.List;
import java.util.Optional;

public interface EquipmentMatriculesService {
    EquipmentMatricule saveEquipmentMatricule(Equipment equipment);
    EquipmentMatricule updateEquipmentMatricule(Long id, EquipmentMatricule equipment);
    void deleteEquipemntMatricule(EquipmentMatricule equipmentMatricule);
    List<EquipmentMatricule> ShowAllEquipmentMatricule();
    EquipmentMatricule searchEquipementMatricule(EquipmentMatricule equipmentMatricule);
    EquipmentMatricule historicForEquipment(EquipmentMatricule matricule);
}
