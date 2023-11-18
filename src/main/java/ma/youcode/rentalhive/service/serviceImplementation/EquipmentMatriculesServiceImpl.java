package ma.youcode.rentalhive.service.serviceImplementation;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import ma.youcode.rentalhive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service @AllArgsConstructor
public class EquipmentMatriculesServiceImpl implements EquipmentMatriculesService {
    private EquipmentMatriculeDao equipmentMatriculeDao;
    private EquipmentService equipmentService;

    public EquipmentMatriculesServiceImpl() {
    }

    @Override
    public Equipment saveEquipmentMatricule(Equipment equipment) {
        Equipment equipmentSaved = equipmentService.createEquipment(equipment);
        for (int i = 0; i < equipmentSaved.getQuantity(); i++) {
            String matriculeUUID = UUID.randomUUID().toString();
            EquipmentMatricule matricule = new EquipmentMatricule();
            matricule.setMatricule(matriculeUUID);
            matricule.setEquipment(equipmentSaved);
        }
        return equipmentSaved;
    }

    @Override
    public EquipmentMatricule updateEquipmentMatricule(Equipment equipment) {
        return null;
    }

    @Override
    public void deleteEquipemntMatricule(EquipmentMatricule equipmentMatricule) {

    }

    @Override
    public List<EquipmentMatricule> ShowAllEquipmentMatricule() {
        return null;
    }

    @Override
    public EquipmentMatricule searchEquipementMatricule(EquipmentMatricule equipmentMatricule) {
        return null;
    }

    @Override
    public EquipmentMatricule historicForEquipment(EquipmentMatricule matricule) {
        return null;
    }

    @Override
    public void validateEquipmentMatricule(EquipmentMatricule matricule) {}
}
