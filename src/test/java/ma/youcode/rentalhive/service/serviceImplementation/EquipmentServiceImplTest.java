package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;
import ma.youcode.rentalhive.service.CategoryService;
import ma.youcode.rentalhive.service.EquipmentService;
import ma.youcode.rentalhive.service.ManufactorerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    Manufacturer createManufactorer(){
        Manufacturer manufactorer = new Manufacturer();
        manufactorer.setId(1L);
        manufactorer.setManufacturer("Caterpillar Inc");
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
        Category category1 = new Category();
        category1.setId(1L);
        equipment.setCategory(category1);
        Mockito.when(equipmentService.checkCategoryIfExistForCreateEquipment(equipment.getCategory().getId()))
                .thenReturn(null);

        Manufacturer manufactorer = createManufactorer();

        Mockito.when(equipmentService.createEquipment(equipment))
                .thenThrow(IllegalArgumentException.class);
        assertThrows(
                IllegalArgumentException.class,
                ()->equipmentService.createEquipment(equipment),
                "should valid category in case not exist in database"
        );
    }
    @Test
    void testCreateEquipmentForPreExistingEquipmentAndThrowException(){
        Equipment equipment = createEquipment();
        Mockito.when(equipmentService.checkEquipmentIfExist(equipment.getName()))
                .thenReturn(
                        Optional.of(equipment));

        Category category = createCategory();

        Manufacturer manufactorer = createManufactorer();

        Mockito.when(equipmentService
                        .createEquipment(equipment))
                .thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,
                ()->equipmentService.createEquipment(equipment),
                "should valid case when equipment is already exist");

    }
    @Test
    void testCreateEquipmentSuccess(){
        Equipment equipment = createEquipment();
        Mockito.when(equipmentService.checkEquipmentIfExist(equipment.getName()))
                .thenReturn(null);

        Category category = createCategory();
        Mockito.when(equipmentService.checkCategoryIfExistForCreateEquipment(1L))
                .thenReturn(null);

        Manufacturer manufacturer = createManufactorer();

        Mockito.when(equipmentService.
                        fetshOrCreateEquipmentManufactorer(manufacturer.getManufacturer()))
                .thenReturn(Optional.of(manufacturer));
        Mockito.when(equipmentService
                        .createEquipment(equipment))
                .thenAnswer(invocationOnMock -> {
                Equipment equipmentSaved = equipment;
                equipmentSaved.setId(1L);
                return equipmentSaved;
                });
        Equipment equipmentSaved = equipmentService.createEquipment(equipment);
        Equipment equipmentExpected = equipment;
        equipmentExpected.setId(1L);
        assertEquals(equipmentExpected, equipmentSaved);

    }
    @ParameterizedTest
    @MethodSource("testDataAttribute")
    void testCreateEquipmentAttributeForNull(Equipment equipment, String nullField) throws IllegalAccessException {
        Field[] fields = equipment.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(field.getName() == nullField){
                field.set(equipment,null);
            }
        }
    assertThrows(IllegalArgumentException.class,
            ()->equipmentService.createEquipment(equipment),
            "one of this stock fiels is null");
    }
    @ParameterizedTest
    @MethodSource("testDataAttribute")
    void testCreateEquipmentAttributeForBlank(Equipment equipment, String nullField) throws IllegalAccessException {
        Field[] fields = equipment.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(field.getName() == nullField){
                field.set(equipment,"");
            }
        }
        assertThrows(IllegalArgumentException.class,
                ()->equipmentService.createEquipment(equipment),
                "one of this stock fiels is null");
    }

    Stream<Arguments> testDataAttribute(){
        Equipment equipment = createEquipment();
        equipment.setCategory(createCategory());
        equipment.setManufacturer(createManufactorer());
        return Stream.of(
                Arguments.of(equipment, "name"),
                Arguments.of(equipment, "quantity"),
                Arguments.of(equipment, "pricePerDay"),
                Arguments.of(equipment, "manufacturer"),
                Arguments.of(equipment, "category")
        );
    }

}