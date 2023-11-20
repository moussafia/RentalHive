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
import java.util.Optional;

@Service
public class EquipmentMatriculesServiceImpl implements EquipmentMatriculesService {
    private EquipmentMatriculeDao equipmentMatriculeDao;
    private EquipmentService equipmentService;
    @Autowired
    public EquipmentMatriculesServiceImpl(EquipmentMatriculeDao equipmentMatriculeDao) {
        this.equipmentMatriculeDao = equipmentMatriculeDao;
        this.equipmentService = equipmentService;
    }
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
            equipmentMatriculeDao.save(matricule);
        }
        return equipmentSaved;
    }

    @Override
    public EquipmentMatricule updateEquipmentMatricule(Long id, EquipmentMatricule equipment) {
        Optional<EquipmentMatricule> updatedEquipmentOptional = equipmentMatriculeDao.findById(id);
        if (updatedEquipmentOptional.isPresent() && equipment != null) {
            EquipmentMatricule updatedEquipment = updatedEquipmentOptional.get();
            updatedEquipment.setId(id);
            updatedEquipment.getEquipment().setName(equipment.getEquipment().getName());
            updatedEquipment.getEquipment().setQuantity(equipment.getEquipment().getQuantity());
            updatedEquipment.getEquipment().setCategory(equipment.getEquipment().getCategory());
            updatedEquipment.getEquipment().setEquipmentMatricule(equipment.getEquipment().getEquipmentMatricule());
            updatedEquipment.getEquipment().setManufacturer(equipment.getEquipment().getManufacturer());
            updatedEquipment.getEquipment().setPricePerDay(equipment.getEquipment().getPricePerDay());

            return equipmentMatriculeDao.save(updatedEquipment);
        }
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
    public Optional<EquipmentMatricule> findById(Long id) {
        return equipmentMatriculeDao.findById(id);
    }
    @Override
    public void validateEquipmentMatricule(EquipmentMatricule matricule) {}
}
