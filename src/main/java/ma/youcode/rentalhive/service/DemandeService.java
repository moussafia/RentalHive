package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Demande;

public interface DemandeService {
    Demande createDemande(Demande demande);
    void deleteDemande(Demande demande);
}
