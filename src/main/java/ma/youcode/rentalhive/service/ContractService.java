package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Contract;
import ma.youcode.rentalhive.entities.Demande;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContractService {
    Contract createContarct(Demande demande ,
            List<EquipmentMatricule> equipmentMatricule);
    Contract updateContract(Contract contract);
}
