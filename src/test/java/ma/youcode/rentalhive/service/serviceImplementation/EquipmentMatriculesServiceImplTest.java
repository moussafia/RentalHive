package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dao.EquipmentMatriculeDao;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

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
    @Test
    public void testUpdateEquipmentMatricule() {
        // Arrange
        Long id = 1L;
        EquipmentMatricule originalEquipment = createSampleEquipmentMatricule("Original Equipment");
        EquipmentMatricule updatedEquipment = createSampleEquipmentMatricule("Updated Equipment");

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
        // Arrange
        Long id = 1L;
        EquipmentMatricule updatedEquipment = createSampleEquipmentMatricule("Updated Equipment");

        when(equipmentMatriculeDao.findById(id)).thenReturn(Optional.empty());

        // Act
        EquipmentMatricule result = equipmentMatriculeService.updateEquipmentMatricule(id, updatedEquipment);

        // Assert
        assertEquals(null, result);
        verify(equipmentMatriculeDao, times(1)).findById(id);
        verify(equipmentMatriculeDao, times(0)).save(any(EquipmentMatricule.class));
    }

    private EquipmentMatricule createSampleEquipmentMatricule(String name) {
        EquipmentMatricule equipmentMatricule = new EquipmentMatricule();
        equipmentMatricule.setEquipment(new Equipment(name, 5, "Category", "Matricule", "Manufacturer", 10.0));
        return equipmentMatricule;
    }
}