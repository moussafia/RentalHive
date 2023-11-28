package ma.youcode.rentalhive.Factory.Implementation;

import ma.youcode.rentalhive.Factory.EquipmentSeeder;
import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EquipmentSeederImpl implements EquipmentSeeder {
    private EquipmentMatriculesService equipmentMatriculesService;

    public EquipmentSeederImpl(EquipmentMatriculesService equipmentMatriculesService) {

        this.equipmentMatriculesService = equipmentMatriculesService;
    }

    @Override
    public void CreateEquipmentSeeder() {
        Equipment equipment1 = new Equipment().builder().name("excavatrices").quantity(10).pricePerDay(1002F).currency("MAD")
                .manufacturer(new Manufacturer().builder().manufacturer("LafargeHolcim").build())
                .category(new Category().builder().id(1L).build()).build();
        Equipment equipment2 = new Equipment().builder().name("bétonnières").quantity(8).pricePerDay(1000F).currency("MAD")
                .manufacturer(new Manufacturer().builder().manufacturer("CEMEX").build())
                .category(new Category().builder().id(2L).build()).build();
        Equipment equipment3 = new Equipment().builder().name("échafaudages").quantity(9).pricePerDay(2000F).currency("MAD")
                .manufacturer(new Manufacturer().builder().manufacturer("HeidelbergCement").build())
                .category(new Category().builder().id(3L).build()).build();
        List<Equipment> equipmentList = List.of(equipment1, equipment2, equipment3);
        equipmentList.forEach(e -> equipmentMatriculesService.saveEquipmentMatricule(e));
    }
}
