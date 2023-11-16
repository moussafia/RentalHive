package ma.youcode.rentalhive.controllers;

import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.service.serviceImplementation.EquipmentCrudServiceImpl;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    private final EquipmentCrudServiceImpl equipementService;
    public EquipmentController( EquipmentCrudServiceImpl equipementService) {
        this.equipementService = equipementService;
    }


    @PostMapping("/update")
    public Equipment update(@RequestBody @Valid Equipment equipment) {
        return equipementService.updateEquipment(equipment);
    }
}
