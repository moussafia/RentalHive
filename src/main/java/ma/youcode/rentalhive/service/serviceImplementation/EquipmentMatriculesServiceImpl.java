package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import ma.youcode.rentalhive.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentMatriculesServiceImpl implements EquipmentMatriculesService {
    private EquipmentMatriculeDao equipmentMatriculeDao;
    private EquipmentService equipmentService;
    @Autowired
    public EquipmentMatriculesServiceImpl(EquipmentMatriculeDao equipmentMatriculeDao, EquipmentService equipmentService) {
        this.equipmentMatriculeDao = equipmentMatriculeDao;
        this.equipmentService = equipmentService;
    }

    public EquipmentMatriculesServiceImpl() {
    }

    @Override
    public Equipment saveEquipmentMatricule(Equipment equipment) {
        Equipment equipmentSaved = equipmentService.createEquipment(equipment);
        Integer quantityEquipment = equipmentSaved.getQuantity();
        for (int i = 0; i < quantityEquipment; i++) {
            String matriculeUUID = UUID.randomUUID().toString();
            EquipmentMatricule matricule = new EquipmentMatricule();
            matricule.setMatricule(matriculeUUID);
            matricule.setEquipment(equipmentSaved);
            equipmentMatriculeDao.save(matricule);
        }
        return equipmentSaved;
    }
    @Override
    public EquipmentMatricule findEqupmentMatriculeById(Long id){
        return equipmentMatriculeDao.findById(id).orElse(null);
    }

    @Override
    public EquipmentMatricule updateEquipmentMatricule(Long id, EquipmentMatricule equipment) {
        return null;
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