package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.*;
import ma.youcode.rentalhive.entities.enums.Status;
import ma.youcode.rentalhive.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipmentMatriculesServiceImplTest {

    EquipmentMatriculeDao equipmentMatriculeDao;
    CategoryDao categoryDao;
    ManufactoreDao manufactoreDao;
    EquipmentMatriculesServiceImpl equipmentMatriculeService;
    @BeforeEach
    void setUp() {
        equipmentMatriculeDao = Mockito.mock(EquipmentMatriculeDao.class);
        categoryDao = Mockito.mock(CategoryDao.class);
        manufactoreDao = Mockito.mock(ManufactoreDao.class);
        equipmentMatriculeService = new EquipmentMatriculesServiceImpl();
    }

    EquipmentMatricule createEquipmentMatricule() {
        EquipmentMatricule equipmentMatricule = new EquipmentMatricule();
        equipmentMatricule.setMatricule(UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        Equipment equipment = createEquipment();
        equipmentMatricule.setEquipment(equipment);

        Contract contract = createFakeContract();
        Set<Contract> contracts = new HashSet<>();
        contracts.add(contract);
        equipmentMatricule.setContracts(contracts);

        return equipmentMatricule;
    }

    Equipment createEquipment() {
        Equipment equipment = new Equipment();
        equipment.setName("Fake Equipment");
        equipment.setQuantity(10);
        equipment.setPricePerDay(15.0F);

        Manufactorer manufactorer = createManufactorer();
        equipment.setManufactorer(manufactorer);

        Category category = createCategory();
        equipment.setCategory(category);

        return equipment;
    }

    private static Manufactorer createManufactorer() {
        Manufactorer manufactorer = new Manufactorer();
        manufactorer.setManufactorer("Fake Manufacturer");

        return manufactorer;
    }

    private static Category createCategory() {
        Category category = new Category();
        category.setName("Fake Category");

        return category;
    }

    private static Contract createFakeContract() {
        Contract contract = new Contract();
        contract.setStatus(Status.FULFILLED);
        contract.setPrice(100.0F);

        return contract;
    }
    @Test
    public void testUpdateEquipmentMatricule() {
        // Arrange
        Long id = 1L;
        EquipmentMatricule originalEquipment = createEquipmentMatricule();
        EquipmentMatricule updatedEquipment = createEquipmentMatricule();

        when(equipmentMatriculeDao.findById(id)).thenReturn(Optional.of(originalEquipment));
        when(equipmentMatriculeDao.save(any(EquipmentMatricule.class))).thenReturn(updatedEquipment);

        // Act
        EquipmentMatricule result = equipmentMatriculeService.updateEquipmentMatricule(id, updatedEquipment);

        // Assert
        assertEquals(updatedEquipment, result);
        verify(equipmentMatriculeDao, times(1)).findById(id);
        verify(equipmentMatriculeDao, times(1)).save(any(EquipmentMatricule.class));
    }

    @Test
    public void testUpdate_EquipmentDoesNotExist() {
        Long id = 1L;
        EquipmentMatricule updatedEquipment = createEquipmentMatricule();

        when(equipmentMatriculeDao.findById(id)).thenReturn(Optional.empty());

        EquipmentMatricule result = equipmentMatriculeService.updateEquipmentMatricule(id, updatedEquipment);

        assertEquals(null, result);
        verify(equipmentMatriculeDao, times(1)).findById(id);
        verify(equipmentMatriculeDao, times(0)).save(any(EquipmentMatricule.class));
    }
}