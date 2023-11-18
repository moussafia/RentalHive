package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.dto.EquipmentDto;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Equipment", produces="application/json")
public class EquipmentController {
    private final EquipmentMatriculesService equipmentMatriculesService;

    public EquipmentController(EquipmentMatriculesService equipmentMatriculesService) {
        this.equipmentMatriculesService = equipmentMatriculesService;
    }

    @RequestMapping(value = "/saveEquipment",method = RequestMethod.POST ,consumes = "application/json")
 public EquipmentDto saveEquipment(@RequestBody EquipmentDto equipmentDto){
        Equipment equipment = new Equipment();
        equipment.setName(equipmentDto.getName());
        equipment.setPricePerDay(equipmentDto.getPricePerDay());
        equipment.setQuantity(equipmentDto.getQuantity());
        equipment.setPricePerDay(equipmentDto.getPricePerDay());
        Category category = new Category();
        category.setId(equipmentDto.getCategory_id());
        equipment.setCategory(category);
        equipmentMatriculesService.saveEquipmentMatricule(equipment);
        return equipmentDto;
}
}
