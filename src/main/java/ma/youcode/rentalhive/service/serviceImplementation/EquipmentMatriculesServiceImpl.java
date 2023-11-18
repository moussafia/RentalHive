package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentMatriculesServiceImpl implements EquipmentMatriculesService {
    private EquipmentMatriculeDao equipmentMatriculeDao;

    public EquipmentMatriculesServiceImpl(EquipmentMatriculeDao equipmentMatriculeDao) {
        this.equipmentMatriculeDao = equipmentMatriculeDao;
    }
    public EquipmentMatriculesServiceImpl() {
    }

    @Override
    public EquipmentMatricule saveEquipmentMatricule(Equipment equipment) {
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
