package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.DossierReservationDao;
import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;
import ma.youcode.rentalhive.model.domaine.entities.EquipmentMatricule;
import ma.youcode.rentalhive.service.DossierReservationService;
import ma.youcode.rentalhive.service.EquipmentMatriculesService;
import ma.youcode.rentalhive.service.ReservationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DossierReservationServiceImpl implements DossierReservationService {
    private DossierReservationDao dossierReservationDao;
    private ReservationService reservationService;
    private EquipmentMatriculesService equipmentMatriculesService;
    public DossierReservationServiceImpl(DossierReservationDao dossierReservationDao,
             ReservationService reservationService,
             EquipmentMatriculesService equipmentMatriculesService) {
        this.dossierReservationDao = dossierReservationDao;
        this.reservationService = reservationService;
        this.equipmentMatriculesService = equipmentMatriculesService;
    }

    @Override
    public List<DossierReservation> createDossierReservation(DossierReservation dossierReservation) {
        Set<Long> equipmentMatriculeIds = this.countQuantityAvailableForEquipment(dossierReservation);
        Integer quantityAvailable = equipmentMatriculeIds.size();
        if(quantityAvailable > 0)
            return this.saveDossierReservation(equipmentMatriculeIds, dossierReservation);
        return null;
    }

    @Override
    public List<DossierReservation> saveDossierReservation(Set<Long> matriculesDisponibleId, DossierReservation dossierReservation) {
        List<DossierReservation> dossierReservationList = new ArrayList<>();
        matriculesDisponibleId.forEach(mId ->{
            EquipmentMatricule equipmentMatricule = equipmentMatriculesService.findEqupmentMatriculeById(mId);
            dossierReservation.setEquipmentMatricule(equipmentMatricule);
            DossierReservation dossierReservationSaved = dossierReservationDao.save(dossierReservation);
            dossierReservationList.add(dossierReservationSaved);
        });
        return dossierReservationList;
    }
    @Override
    public Set<Long> countQuantityAvailableForEquipment(DossierReservation dossierReservation){
        Long equipmentId = dossierReservation.getEquipmentMatricule().getEquipment().getId();
        Long userID = dossierReservation.getReservation().getUser().getId();
        LocalDateTime startDate = dossierReservation.getStartDate();
        LocalDateTime endDate = dossierReservation.getEndDate();
        Integer quantityRequested = dossierReservation.getEquipmentMatricule().getEquipment().getQuantity();
        Pageable pageable = (Pageable) PageRequest.of(0, quantityRequested);
        Set<Long> equipmentMatriculeIds = dossierReservationDao.countQuantityAvailableForEquipment(equipmentId, userID,
                startDate, endDate , pageable);
        return equipmentMatriculeIds;
    }


}
