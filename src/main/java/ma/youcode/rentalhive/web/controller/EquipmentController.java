package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.serviceImplementation.EquipmentMatriculesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/api", produces="application/json")
public class EquipmentController {
    @Autowired
    EquipmentMatriculesServiceImpl equipmentMatriculesService;

    @PutMapping("/equipment/{id}")
    public ResponseEntity updateEquipment(@PathVariable("id") Long id, @RequestBody EquipmentMatricule equipment) {
        Optional<EquipmentMatricule> equipment1 = equipmentMatriculesService.findById(id);

        if (equipment1.isPresent()) {
            EquipmentMatricule updatedEquipmentMatricule = equipmentMatriculesService.updateEquipmentMatricule(id, equipment);
            return new ResponseEntity<>(updatedEquipmentMatricule.getEquipment(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
