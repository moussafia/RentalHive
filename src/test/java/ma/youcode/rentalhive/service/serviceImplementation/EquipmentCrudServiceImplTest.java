package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentCrudServiceImplTest {

    private EquipmentDao equipmentDao;
    private EquipmentMatriculeDao equipmentMatriculeDao;
    private CategoryDao categoryDao;
    private ManufactoreDao manufactoreDao;

    @BeforeEach
    void setUp(){
        equipmentDao = Mockito.mock(EquipmentDao.class);
        equipmentMatriculeDao = Mockito.mock(EquipmentMatriculeDao.class);
        categoryDao = Mockito.mock(CategoryDao.class);
        manufactoreDao = Mockito.mock(ManufactoreDao.class);
    }
    @Test
    void createEquipment() {

    }

    @Test
    void updateEquipment() {
    }

    @Test
    void searchEquipmentDisponible() {
    }

    @Test
    void historicForEquipment() {
    }
}