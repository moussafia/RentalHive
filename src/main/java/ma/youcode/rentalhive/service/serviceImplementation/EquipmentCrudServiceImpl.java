package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.entities.Equipment;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.entities.Manufactorer;
import ma.youcode.rentalhive.service.EquipmentCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentCrudServiceImpl implements EquipmentCrudService {
    private EquipmentMatricule equipmentMatricule;
    private Equipment equipment;
    private Category category;
    private Manufactorer manufactorer;

    public EquipmentCrudServiceImpl(EquipmentMatricule equipmentMatricule,
                                    Equipment equipment,
                                    Category category,
                                    Manufactorer manufactorer) {
        this.equipmentMatricule = equipmentMatricule;
        this.equipment = equipment;
        this.category = category;
        this.manufactorer = manufactorer;
    }
    public EquipmentCrudServiceImpl(){}

    @Override
    public EquipmentMatricule createEquipment(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule updateEquipment(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule searchEquipmentDisponible(EquipmentMatricule Equipment) {

        return null;
    }

    @Override
    public EquipmentMatricule historicForEquipment(EquipmentMatricule Equipment) {

        return null;
    }
}
