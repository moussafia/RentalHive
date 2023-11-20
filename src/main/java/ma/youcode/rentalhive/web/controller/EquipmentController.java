package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.dto.EquipmentDto;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.Manufacturer;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
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

}
