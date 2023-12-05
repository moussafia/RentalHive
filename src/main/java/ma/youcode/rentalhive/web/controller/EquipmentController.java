package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentDto;
import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import ma.youcode.rentalhive.model.mapper.equipmentDtoMapper.EquipmentDtoMapper;
import ma.youcode.rentalhive.service.serviceImplementation.EquipmentMatriculesServiceImpl;
import ma.youcode.rentalhive.service.serviceImplementation.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/api/v1/equipment", produces="application/json")
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

    @PutMapping("/{id}")
    public ResponseEntity updateEquipment(@PathVariable("id") Long id, @RequestBody EquipmentDto equipmentDto) {
        Optional<Equipment> equipment1 = equipmentDao.findById(id);
        if (equipment1.isPresent()) {
            Equipment updatedEquipment = equipmentService.updateEquipment(id, equipmentDto);
            return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST ,consumes = "application/json")
    public Equipment saveEquipment(@RequestBody EquipmentDto equipmentDto){
        Equipment equipment = EquipmentDtoMapper.toEquipment(equipmentDto);
        return equipmentMatriculesService.saveEquipmentMatricule(equipment);
}
    @GetMapping
    public List<EquipmentDto> getAllEquipment(@RequestParam(defaultValue = "0") Integer page){
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Equipment> equipment = equipmentService.fetchAllEquipment(pageRequest);
        List<EquipmentDto> equipmentDtoList = new ArrayList<>();
        equipment.forEach( e -> {
            CategoryDto categoryDto = new CategoryDto(e.getCategory().getId(),e.getCategory().getName());
            EquipmentDto equipmentDto = new EquipmentDto(e.getId(),
                                    e.getName(),
                                    e.getQuantity(), e.getPricePerDay(),
                                    e.getManufacturer().getManufacturer(),
                                    categoryDto);
            equipmentDtoList.add(equipmentDto);
        });
        return equipmentDtoList;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex){
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(ex.getMessage());
    }
}
