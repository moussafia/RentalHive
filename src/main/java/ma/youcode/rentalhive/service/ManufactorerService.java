package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ManufactorerService {
    Manufacturer createManufactorer(Manufacturer manufactorer);
    Optional<Manufacturer> searchManufactorer(String manufactorer_name);
    void validateManufactorer();
    public void validateManufacturerName(Manufacturer manufactorer);
}
