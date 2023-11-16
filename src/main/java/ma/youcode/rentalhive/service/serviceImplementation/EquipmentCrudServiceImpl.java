package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.entities.Manufactorer;
import ma.youcode.rentalhive.service.EquipmentCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public EquipmentMatricule createEquipment(EquipmentMatricule matricule,
                                              Equipment equipment,
                                              Category category,
                                              Manufactorer manufactorer) {
        return null;
    }

    @Override
    public EquipmentMatricule updateEquipment(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment) {

        return null;
    }
    public void validateCategory(Category category){

    }
    public void validateManufactorer(Manufactorer manufactorer){
    }
    public void validateEquipment(Equipment equipment){
    }
    public void validateEquipmentMatricule(EquipmentMatricule equipmentMatricule){
    }
}
