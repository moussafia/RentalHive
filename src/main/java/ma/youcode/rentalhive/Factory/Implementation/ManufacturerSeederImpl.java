package ma.youcode.rentalhive.Factory.Implementation;

import ma.youcode.rentalhive.Factory.ManufacturerSeeder;
import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManufacturerSeederImpl implements ManufacturerSeeder {
    private ManufactoreDao manufactoreDao;

    public ManufacturerSeederImpl(ManufactoreDao manufactoreDao) {
        this.manufactoreDao = manufactoreDao;
    }

    @Override
    public void CreateManufacturerSeeder() {
        List<String> manufacturer = List.of("LafargeHolcim", "CEMEX", "HeidelbergCement");

            manufacturer.forEach(m -> manufactoreDao.save(new Manufacturer().builder()
                    .manufacturer(m)
                    .build()));
    }
}
