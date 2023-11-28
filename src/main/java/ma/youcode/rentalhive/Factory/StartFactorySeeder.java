package ma.youcode.rentalhive.Factory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StartFactorySeeder {
    private CategorySeeder categorySeeder;
    private ManufacturerSeeder manufacturerSeeder;
    private EquipmentSeeder equipmentSeeder;
    private RoleSeeder roleSeeder;
    private UserSeeder userSeeder;

    public StartFactorySeeder(CategorySeeder categorySeeder,
                              ManufacturerSeeder manufacturerSeeder,
                              EquipmentSeeder equipmentSeeder,
                              RoleSeeder roleSeeder,
                              UserSeeder userSeeder) {
        this.categorySeeder = categorySeeder;
        this.manufacturerSeeder = manufacturerSeeder;
        this.equipmentSeeder = equipmentSeeder;
        this.roleSeeder = roleSeeder;
        this.userSeeder = userSeeder;
    }

    @Bean
    CommandLineRunner start(){
        return args -> {
            categorySeeder.CreateCategorySeeder();
            manufacturerSeeder.CreateManufacturerSeeder();
            equipmentSeeder.CreateEquipmentSeeder();
            roleSeeder.createRoleSeeder();
            userSeeder.createUserSeeder();
        };
    }
}
