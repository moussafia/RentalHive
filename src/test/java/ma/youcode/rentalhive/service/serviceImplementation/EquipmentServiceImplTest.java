package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentServiceImplTest {

    EquipmentDao equipmentDao;
    CategoryDao categoryDao;
    ManufactoreDao manufactoreDao;
    EquipmentService equipmentService;
    @BeforeEach
    void setUp() {
        equipmentDao = Mockito.mock(EquipmentDao.class);
        categoryDao = Mockito.mock(CategoryDao.class);
        manufactoreDao = Mockito.mock(ManufactoreDao.class);
        equipmentService = new EquipmentServiceImpl();
    }

    @Test
    void createEquipment() {
    }


}