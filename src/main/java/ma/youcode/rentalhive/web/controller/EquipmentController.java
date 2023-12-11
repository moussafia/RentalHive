package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.dao.EquipmentDao;
import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentPostDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentResponseDto;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
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
    public ResponseEntity updateEquipment(@PathVariable("id") Long id, @RequestBody EquipmentResponseDto equipmentResponseDto) {
        Optional<Equipment> equipment1 = equipmentDao.findById(id);
        if (equipment1.isPresent()) {
            Equipment updatedEquipment = equipmentService.updateEquipment(id, equipmentResponseDto);
            return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST ,consumes = "application/json")
    public ResponseEntity<Equipment> saveEquipment(@RequestBody EquipmentPostDto equipmentPostDto){
        Equipment equipment = EquipmentDtoMapper.toEquipment(equipmentPostDto);
        return ResponseEntity.ok(equipmentMatriculesService.saveEquipmentMatricule(equipment));
}
    @GetMapping
    public ResponseEntity<List<EquipmentResponseDto>> getAllEquipment(@RequestParam(defaultValue = "0") Integer page){
        PageRequest pageRequest = PageRequest.of(page, 9);
        Page<Equipment> equipment = equipmentService.fetchAllEquipment(pageRequest);
        List<EquipmentResponseDto> equipmentResponseDtoList = new ArrayList<>();
        equipment.forEach( e -> {
            CategoryDto categoryDto = new CategoryDto(e.getCategory().getId(),e.getCategory().getName());
            EquipmentResponseDto equipmentResponseDto = new EquipmentResponseDto(e.getId(),
                                    e.getName(),
                                    e.getQuantity(), e.getPricePerDay(),
                                    e.getManufacturer().getManufacturer(),
                                    categoryDto);
            equipmentResponseDtoList.add(equipmentResponseDto);
        });
        return ResponseEntity.ok()
                .header("X-Total-Page",String.valueOf(equipment.getTotalPages()))
                .header("X-Total-Element",String.valueOf(equipment.getTotalElements()))
                .body(equipmentResponseDtoList);
    }
}
