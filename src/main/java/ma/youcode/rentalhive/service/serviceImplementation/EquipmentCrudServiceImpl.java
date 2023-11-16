package ma.youcode.rentalhive.service.serviceImplementation;
import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentCrudService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentCrudServiceImpl implements EquipmentCrudService {
    private EquipmentMatriculeDao equipmentMatriculeDao;
    private EquipmentDao equipmentDao;
    private CategoryDao categoryDao;
    private ManufactoreDao manufactoreDao;
    public EquipmentCrudServiceImpl(EquipmentMatriculeDao equipmentMatriculeDao,
                                    EquipmentDao equipmentDao,
                                    CategoryDao categoryDao,
                                    ManufactoreDao manufactoreDao) {
        this.equipmentMatriculeDao = equipmentMatriculeDao;
        this.equipmentDao = equipmentDao;
        this.categoryDao = categoryDao;
        this.manufactoreDao = manufactoreDao;
    }

    public EquipmentCrudServiceImpl(){}

    @Override
    public EquipmentMatricule createEquipment(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule updateEquipment(Long id, EquipmentMatricule equipment) {
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
    public EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment) {

        return null;
    }

    public Optional<Equipment> findById(Long id) {
        return equipmentDao.findById(id);
    }
}
