package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentMatriculesService {
    EquipmentMatricule saveEquipmentMatricule(Equipment equipment);
    EquipmentMatricule updateEquipmentMatricule(Equipment equipment);
    void deleteEquipemntMatricule(EquipmentMatricule equipmentMatricule);
    List<EquipmentMatricule> ShowAllEquipmentMatricule();
    EquipmentMatricule searchEquipementMatricule(EquipmentMatricule equipmentMatricule);
    EquipmentMatricule historicForEquipment(EquipmentMatricule matricule);
    void validateEquipmentMatricule(EquipmentMatricule matricule);


}
