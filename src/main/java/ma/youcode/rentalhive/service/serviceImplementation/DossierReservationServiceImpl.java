package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.DossierReservationDao;
import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;
import ma.youcode.rentalhive.model.domaine.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.DossierReservationService;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import ma.youcode.rentalhive.service.ReservationService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DossierReservationServiceImpl implements DossierReservationService {
    private DossierReservationDao dossierReservationDao;
    private EquipmentMatriculesService equipmentMatriculesService;
    public DossierReservationServiceImpl(DossierReservationDao dossierReservationDao,
             EquipmentMatriculesService equipmentMatriculesService) {
        this.dossierReservationDao = dossierReservationDao;
        this.equipmentMatriculesService = equipmentMatriculesService;
    }

    @Override
    public List<DossierReservation> createDossierReservation(DossierReservation dossierReservation) {
        Set<Integer> equipmentMatriculeIds = this.getEquipmentMatriculeAvailable(dossierReservation);
        Integer quantityAvailable = equipmentMatriculeIds.size();
        if(quantityAvailable > 0)
            return this.saveDossierReservation(equipmentMatriculeIds, dossierReservation);
        return null;
    }

    @Override
    public Set<Integer> getEquipmentMatriculeAvailable(DossierReservation dossierReservation){
        Long equipmentId = dossierReservation.getEquipmentMatricule().getEquipment().getId();
        Long userID = dossierReservation.getReservation().getUser().getId();
        LocalDateTime startDate = dossierReservation.getStartDate();
        LocalDateTime endDate = dossierReservation.getEndDate();
        Integer quantityRequested = dossierReservation.getEquipmentMatricule().getEquipment().getQuantity();
        Set<Integer> equipmentMatriculeIds = dossierReservationDao.fetshEquipmentAvailable(equipmentId, userID,
                startDate, endDate,  quantityRequested);
        return equipmentMatriculeIds;
    }
    @Override
    public List<DossierReservation> saveDossierReservation(Set<Integer> matriculesDisponibleId, DossierReservation dossierReservation) {
        List<DossierReservation> dossierReservationList = new ArrayList<>();
        Integer quantityAvailable = matriculesDisponibleId.size();
        Integer quantityRequested = dossierReservation.getEquipmentMatricule().getEquipment().getQuantity();
        matriculesDisponibleId.forEach(mId ->{
            EquipmentMatricule equipmentMatricule = equipmentMatriculesService.findEqupmentMatriculeById(Long.valueOf(mId));
            DossierReservation dossierReservationForSaving = new DossierReservation().builder()
                    .reservation(dossierReservation.getReservation())
                    .startDate(dossierReservation.getStartDate())
                    .endDate(dossierReservation.getEndDate())
                    .equipmentMatricule(equipmentMatricule)
                    .build();
            DossierReservation dossierReservationSaved = dossierReservationDao.save(dossierReservationForSaving);
            Float PriceTotalForEquipment = calculPriceForReservation(dossierReservationSaved, quantityAvailable);
            dossierReservationSaved.setQuantityAvailable(quantityAvailable);
            dossierReservationSaved.setQuantityRequested(quantityRequested);
            dossierReservationSaved.setPriceTotalForEquipment(PriceTotalForEquipment);
            dossierReservationList.add(dossierReservationSaved);
        });
        return dossierReservationList;
    }

    public Float calculPriceForReservation(DossierReservation dossierReservation,Integer quantityAvailable){
        Float priceEquipmentPerDay= dossierReservation.getEquipmentMatricule().getEquipment().getPricePerDay();
        return priceEquipmentPerDay*quantityAvailable;
    }
}
