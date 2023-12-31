package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dto.EquipmentDto;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;
import ma.youcode.rentalhive.service.serviceImplementation.EquipmentMatriculesServiceImpl;
import ma.youcode.rentalhive.service.serviceImplementation.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/api", produces="application/json")
public class EquipmentController {

    EquipmentServiceImpl equipmentService;
    EquipmentDao equipmentDao;
    EquipmentMatriculesServiceImpl equipmentMatriculesService;
    @Autowired
    public EquipmentController(EquipmentServiceImpl equipmentService, EquipmentDao equipmentDao, EquipmentMatriculesServiceImpl equipmentMatriculesService) {
        this.equipmentService = equipmentService;
        this.equipmentDao = equipmentDao;
        this.equipmentMatriculesService = equipmentMatriculesService;
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity updateEquipment(@PathVariable("id") Long id, @RequestBody EquipmentDto equipmentDto) {
        Optional<Equipment> equipment1 = equipmentDao.findById(id);
        if (equipment1.isPresent()) {
            Equipment updatedEquipment = equipmentService.updateEquipment(id, equipmentDto);
            return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/saveEquipment",method = RequestMethod.POST ,consumes = "application/json")
    public Equipment saveEquipment(@RequestBody EquipmentDto equipmentDto){
        Equipment equipment = new Equipment();
        equipment.setName(equipmentDto.getName());
        equipment.setPricePerDay(equipmentDto.getPricePerDay());
        equipment.setQuantity(equipmentDto.getQuantity());
        equipment.setPricePerDay(equipmentDto.getPricePerDay());
        Category category = new Category();
        category.setId(equipmentDto.getCategory_id());
        equipment.setCategory(category);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer(equipmentDto.getManufacturerName());
        equipment.setManufacturer(manufacturer);
        return equipmentMatriculesService.saveEquipmentMatricule(equipment);
}
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
