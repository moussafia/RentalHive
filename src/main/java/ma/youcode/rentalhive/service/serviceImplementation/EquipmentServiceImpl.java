package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufactorer;
import ma.youcode.rentalhive.service.EquipmentService;

import java.time.LocalDateTime;
import java.util.List;

public class EquipmentServiceImpl implements EquipmentService {
    private EquipmentMatriculeDao equipmentMatriculeDao;
    private EquipmentDao equipmentDao;
    private CategoryDao categoryDao;
    private ManufactoreDao manufactoreDao;
    public EquipmentServiceImpl(EquipmentMatriculeDao equipmentMatriculeDao,
                                EquipmentDao equipmentDao,
                                CategoryDao categoryDao,
                                ManufactoreDao manufactoreDao) {
        this.equipmentMatriculeDao = equipmentMatriculeDao;
        this.equipmentDao = equipmentDao;
        this.categoryDao = categoryDao;
        this.manufactoreDao = manufactoreDao;
    }
    @Override
    public Equipment createEquipment(Equipment equipment,
                                     Category category,
                                     Manufactorer manufactorer) {
        return null;
    }

    @Override
    public Equipment updateEquipment(Equipment equipment,
                                     Category category,
                                     Manufactorer manufactorer) {
        return null;
    }

    @Override
    public List<Equipment> searchEquipmentDisponible(Equipment equipment,
                                                     LocalDateTime dateTime) {
        return null;
    }
}
