package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;
import ma.youcode.rentalhive.service.CategoryService;
import ma.youcode.rentalhive.service.EquipmentService;
import ma.youcode.rentalhive.service.ManufactorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private EquipmentDao equipmentDao;
    private CategoryService categoryService;
    private ManufactorerService manufactorerService;

    @Autowired
    public EquipmentServiceImpl(EquipmentDao equipmentDao,
                                CategoryService categoryService,
                                ManufactorerService manufactorerService) {
        this.equipmentDao = equipmentDao;
        this.categoryService = categoryService;
        this.manufactorerService = manufactorerService;
    }

    public EquipmentServiceImpl() {
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {


        return null;
    }

    @Override
    public Equipment updateEquipment(Long id,Equipment equipment) {
        return null;
    }

    @Override
    public List<Equipment> searchEquipmentDisponible(Equipment equipment, LocalDateTime dateTime) {
        return null;
    }

    @Override
    public Optional<Equipment> checkEquipmentIfExist(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> checkCategoryIfExistForCreateEquipment(Long category_id) {
        return Optional.empty();
    }

    @Override
    public void validateEquipment() {

    }

    @Override
    public Optional<Manufacturer> fetshOrCreateEquipmentManufactorer(String manufactorer) {
        return Optional.empty();
    }


}
