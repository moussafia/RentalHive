package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufactorer;
import ma.youcode.rentalhive.service.CategoryService;
import ma.youcode.rentalhive.service.EquipmentService;
import ma.youcode.rentalhive.service.ManufactorerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class EquipmentServiceImplTest {

    private EquipmentDao equipmentDao;
    private CategoryService categoryService;
    private ManufactorerService manufactorerService;
    private EquipmentService equipmentService;
    @BeforeEach
    void setUp() {
        equipmentDao = Mockito.mock(EquipmentDao.class);
        categoryService = Mockito.mock(CategoryService.class);
        manufactorerService = Mockito.mock(ManufactorerService.class);
        equipmentService = new EquipmentServiceImpl();
    }
    Category createCategory(){
        Category category = new Category();
        category.setId(1L);
        category.setName("Caterpillar 320D");
        return category;
    }
    Manufactorer createManufactorer(){
        Manufactorer manufactorer = new Manufactorer();
        manufactorer.setId(1L);
        manufactorer.setManufactorer("Caterpillar Inc");
        return manufactorer;
    }
    Equipment createEquipment(){
        Equipment equipment = new Equipment();
        equipment.setName("excavatrices");
        equipment.setPricePerDay(10000.30F);
        equipment.setQuantity(null);
        return equipment;
    }
    @Test
    void testCreateEquipmentForCategoryNotExistAndThrowException(){
        Equipment equipment = createEquipment();
        Mockito.when(equipmentService.checkEquipmentIfExist(equipment.getName()))
                .thenReturn(null);

        Category category = createCategory();

        Mockito.when(equipmentService
                        .checkCategoryIfExistForCreateEquipment(1L))
                .thenReturn(null);

        Manufactorer manufactorer = createManufactorer();

        Mockito.when(equipmentService
                .createEquipment(equipment,
                        category.getId(),
                        manufactorer.getManufactorer()))
                .thenThrow(RuntimeException.class);
    }
    @Test
    void testCreateEquipmentForPreExistingEquipmentAndThrowException(){
        Equipment equipment = createEquipment();
        Mockito.when(equipmentService.checkEquipmentIfExist(equipment.getName()))
                .thenReturn(
                        Optional.of(equipment));

        Category category = createCategory();

        Manufactorer manufactorer = createManufactorer();

        Mockito.when(equipmentService
                        .createEquipment(equipment,
                                category.getId(),
                                manufactorer.getManufactorer()))
                .thenThrow(RuntimeException.class);


    }
    @Test
    void testCreateEquipmentSuccess(){
        Equipment equipment = createEquipment();
        Mockito.when(equipmentService.checkEquipmentIfExist(equipment.getName()))
                .thenReturn(null);

        Category category = createCategory();
        Mockito.when(equipmentService.checkCategoryIfExistForCreateEquipment(1L))
                .thenReturn(null);

        Manufactorer manufactorer = createManufactorer();

        Mockito.when(equipmentService.
                        fetshOrCreateEquipmentManufactorer(manufactorer.getManufactorer()))
                .thenReturn(Optional.of(manufactorer));
        Mockito.when(equipmentService
                        .createEquipment(equipment,
                                category.getId(),
                                manufactorer.getManufactorer()))
                .thenThrow(RuntimeException.class);
    }
}