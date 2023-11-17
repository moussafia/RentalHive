package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.dao.DemandeDao;
import ma.youcode.rentalhive.entities.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface DemandeService {

    Demande createDemande(Demande demande);

    Demande updateDemande(Demande demande);

}
