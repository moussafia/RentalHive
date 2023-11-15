package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Contract;
import ma.youcode.rentalhive.entities.Demande;
import ma.youcode.rentalhive.entities.EquipmentMatricule;

import java.util.List;

public interface ContractService {
    Contract requestLocationEquipment(List<EquipmentMatricule> equipmentMatricule);
    Contract updateContract(Contract contract);
}