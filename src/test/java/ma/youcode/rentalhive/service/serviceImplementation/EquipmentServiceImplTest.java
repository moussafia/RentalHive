package ma.youcode.rentalhive.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;
import ma.youcode.rentalhive.service.CategoryService;
import ma.youcode.rentalhive.service.EquipmentService;
import ma.youcode.rentalhive.service.ManufactorerService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
class EquipmentServiceImplTest {

    private EquipmentDao equipmentDao;
    private CategoryService categoryService;
    private ManufactorerService manufactorerService;
    private EquipmentService equipmentServiceMocked;
    @BeforeEach
    void setUp() {
        equipmentDao = Mockito.mock(EquipmentDao.class);
        categoryService = Mockito.mock(CategoryServiceImpl.class);
        manufactorerService = Mockito.mock(ManufactorerServiceImpl.class);
        equipmentServiceMocked = mock(EquipmentServiceImpl.class);


    }
    static Category createCategory(){
        Category category = new Category();
        category.setId(1L);
        category.setName("Caterpillar 320D");
        return category;
    }
    static Manufacturer createManufactorer(){
        Manufacturer manufactorer = new Manufacturer();
        manufactorer.setId(1L);
        manufactorer.setManufacturer("Caterpillar Inc");
        return manufactorer;
    }
    static Equipment createEquipment(){
        Equipment equipment = new Equipment();
        equipment.setName("excavatrices");
        equipment.setPricePerDay(10000.30F);
        equipment.setQuantity(30); //check again
        Category category1 = new Category();
        category1.setId(1L);
        equipment.setCategory(category1);
        return equipment;
    }
    @Test
    void testCreateEquipmentForCategoryNotExistAndThrowException(){
        Equipment equipment = createEquipment();
        doNothing().when(equipmentServiceMocked).checkEquipmentIfExist(equipment.getName());
        Mockito.when(equipmentServiceMocked.checkCategoryIfExistForCreateEquipment(equipment.getCategory().getId()))
                .thenThrow(RuntimeException.class);
        Mockito.when(equipmentServiceMocked.createEquipment(equipment))
                .thenThrow(RuntimeException.class);
        assertThrows(
                RuntimeException.class,
                ()->equipmentServiceMocked.createEquipment(equipment),
                "should valid category in case not exist in database"
        );
    }
    @Test
    void testCreateEquipmentForPreExistingEquipmentAndThrowException(){
        Equipment equipment = createEquipment();
        doThrow(new RuntimeException()).when(equipmentServiceMocked)
                .checkEquipmentIfExist(equipment.getName());
        Mockito.when(equipmentServiceMocked
                        .createEquipment(equipment))
                .thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,
                ()->equipmentServiceMocked.createEquipment(equipment),
                "should valid case when equipment is already exist");
    }
    @Test
    void testCreateEquipmentSuccess(){
        Equipment equipment = createEquipment();
        doNothing().when(equipmentServiceMocked).checkEquipmentIfExist(equipment.getName());
        Category category = createCategory();
        Mockito.when(equipmentServiceMocked.checkCategoryIfExistForCreateEquipment(1L))
                .thenReturn(category);
        Manufacturer manufacturer = createManufactorer();
        Mockito.when(equipmentServiceMocked.
                        fetshOrCreateEquipmentManufactorer(manufacturer.getManufacturer()))
                .thenReturn(manufacturer);
        Mockito.when(equipmentServiceMocked
                        .createEquipment(equipment))
                .thenAnswer(invocationOnMock -> {
                Equipment equipmentSaved = equipment;
                equipmentSaved.setId(1L);
                return equipmentSaved;
                });
        Equipment equipmentSaved = equipmentServiceMocked.createEquipment(equipment);
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
            if(field.getName().equals(nullField)){
                field.set(equipment, null);
            }
        }
    Mockito.when(equipmentServiceMocked
                        .createEquipment(equipment))
                .thenThrow(IllegalArgumentException.class);
    assertThrows(IllegalArgumentException.class,
            ()->equipmentServiceMocked.createEquipment(equipment),
            "the field of "+ nullField +" is blank");
    }
    @ParameterizedTest
    @MethodSource("testDataAttribute")
    void testCreateEquipmentAttributeForBlank(Equipment equipment, String nullField) throws IllegalAccessException {
        Field[] fields = equipment.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(field.getName().equals(nullField) && field.getType().equals(String.class)){
                field.set(equipment,"");
            }
        }
        Mockito.when(equipmentServiceMocked
                        .createEquipment(equipment))
                .thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class,
                ()->equipmentServiceMocked.createEquipment(equipment),
                "the field of "+ nullField +" is blank");
    }

    private static Stream<Arguments> testDataAttribute(){
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