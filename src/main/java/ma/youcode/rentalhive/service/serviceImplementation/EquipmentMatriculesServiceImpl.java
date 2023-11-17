package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentMatriculesServiceImpl implements EquipmentMatriculesService {
    @Autowired
    private EquipmentMatriculeDao equipmentMatriculeDao;
    @Override
    public EquipmentMatricule saveEquipmentMatricule(Equipment equipment) {
        return null;
    }

    @Override
    public EquipmentMatricule updateEquipmentMatricule(Long id, EquipmentMatricule equipment) {
        EquipmentMatricule updatedEquipment = equipmentMatriculeDao.findById(id).get();
        updatedEquipment.setId(id);
        updatedEquipment.getEquipment().setName(equipment.getEquipment().getName());
        updatedEquipment.getEquipment().setQuantity(equipment.getEquipment().getQuantity());
        updatedEquipment.getEquipment().setCategory(equipment.getEquipment().getCategory());
        updatedEquipment.getEquipment().setEquipmentMatricule(equipment.getEquipment().getEquipmentMatricule());
        updatedEquipment.getEquipment().setManufactorer(equipment.getEquipment().getManufactorer());
        updatedEquipment.getEquipment().setPricePerDay(equipment.getEquipment().getPricePerDay());

        return equipmentMatriculeDao.save(updatedEquipment);
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

    public Optional<EquipmentMatricule> findById(long id) {
        return equipmentMatriculeDao.findById(id);
    }
}
