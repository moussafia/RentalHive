package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.entities.Contract;
import ma.youcode.rentalhive.entities.Demande;
import ma.youcode.rentalhive.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Override
    public Contract createContarct(Demande demande,
                                   List<EquipmentMatricule> equipmentMatricule) {
        return null;
    }

    @Override
    public Contract updateContract(Contract contract) {
        return null;
    }
}
