package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;

import java.util.List;
import java.util.Set;

public interface DossierReservationService {
    List<DossierReservation> createDossierReservation(DossierReservation dossierReservation);
    List<DossierReservation> saveDossierReservation(Set<Long> matriculesIds, DossierReservation dossierReservation);
    Set<Long> countQuantityAvailableForEquipment(DossierReservation dossierReservation);
}
