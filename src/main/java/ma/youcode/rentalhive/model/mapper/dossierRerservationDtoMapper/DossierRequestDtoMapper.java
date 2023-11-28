package ma.youcode.rentalhive.model.mapper.dossierRerservationDtoMapper;

import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;
import ma.youcode.rentalhive.model.domaine.entities.Equipment;
import ma.youcode.rentalhive.model.domaine.entities.EquipmentMatricule;
import ma.youcode.rentalhive.model.domaine.entities.Reservation;
import ma.youcode.rentalhive.model.domaine.enums.Status;
import ma.youcode.rentalhive.model.dto.dosssierReservationDto.DossierRequestDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DossierRequestDtoMapper {
       public static Set<DossierReservation> toSetDossierReservation(DossierRequestDto dossierRequestDto){
           Set<DossierReservation> dossierReservationSet = new HashSet<>();
           dossierRequestDto.getEquipmentForReservation().forEach(dossier -> {
                DossierReservation dossierReservation= new DossierReservation().builder()
                        .startDate(dossier.getStartDate())
                        .endDate(dossier.getEndDate())
                        .equipmentMatricule(new EquipmentMatricule().builder()
                                .equipment(new Equipment().builder()
                                        .id(dossier.getEquipment_id()).quantity(dossier.getQuantity()).build()).build())
                        .build();
               dossierReservationSet.add(dossierReservation);
           });
           return dossierReservationSet;
    }
}
