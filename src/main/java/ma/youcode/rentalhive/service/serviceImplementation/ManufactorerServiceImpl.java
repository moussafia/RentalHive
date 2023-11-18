package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.ManufactoreDao;
import ma.youcode.rentalhive.entities.Manufacturer;
import ma.youcode.rentalhive.service.ManufactorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManufactorerServiceImpl implements ManufactorerService {
    private ManufactoreDao manufactoreDao;

    @Autowired
    public ManufactorerServiceImpl(ManufactoreDao manufactoreDao) {

        this.manufactoreDao = manufactoreDao;
    }
    public ManufactorerServiceImpl() {
    }

    @Override
    public Manufacturer createManufactorer(Manufacturer manufacturer) {
        validateManufacturerName(manufacturer);
        Optional<Manufacturer> manufactorer1= searchManufactorer(manufacturer.getManufacturer());
        if(manufactorer1.isPresent()){
            return manufactorer1.get();
        }
        return manufactoreDao.save(manufacturer);
    }

    @Override
    public Optional<Manufacturer> searchManufactorer(String manufacturer_name) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturer(manufacturer_name);
        validateManufacturerName(manufacturer);
        return manufactoreDao.findByManufacturer(manufacturer_name);
    }

    @Override
    public void validateManufacturerName(Manufacturer manufactorer){
        if(manufactorer.getManufacturer().isBlank())
            throw new IllegalArgumentException("name of manufacturer should not be blank");
        if(manufactorer.getManufacturer().isEmpty())
            throw new IllegalArgumentException("name of manufacturer should not be empty");
        if(manufactorer.getManufacturer() == null)
            throw new IllegalArgumentException("name of manufacturer should not be null");
        if (!manufactorer.getManufacturer().matches("[a-zA-Z0-9]+"))
            throw new IllegalArgumentException("Name of manufacturer should contain only letters, numbers or both.");
    }
    @Override
    public void validateManufactorer() {

    }
}
