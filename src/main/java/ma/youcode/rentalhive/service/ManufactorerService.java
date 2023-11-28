package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.domaine.entities.Manufacturer;

import java.util.Optional;


public interface ManufactorerService {
    Manufacturer createManufactorer(Manufacturer manufactorer);
    Optional<Manufacturer> searchManufactorer(String manufactorer_name);
    void validateManufactorer();
    public void validateManufacturerName(Manufacturer manufactorer);
}