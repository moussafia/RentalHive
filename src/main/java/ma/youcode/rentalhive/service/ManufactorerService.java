package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Manufactorer;

public interface ManufactorerService {
    Manufactorer createManufactorer(Manufactorer manufactorer);
    Manufactorer searchManufactorer(String manufactorer_name);
    void validateManufactorer();
}
