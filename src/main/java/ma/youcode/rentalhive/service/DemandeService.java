package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Demande;
import org.springframework.stereotype.Service;


public interface DemandeService {
    Demande createDemande(Demande demande);
    void deleteDemande(Demande demande);
}
