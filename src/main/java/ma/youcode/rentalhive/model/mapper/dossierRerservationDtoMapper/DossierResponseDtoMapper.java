package ma.youcode.rentalhive.model.mapper.dossierRerservationDtoMapper;

import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;
import ma.youcode.rentalhive.model.dto.dosssierReservationDto.response.DossierResponseDto;
import ma.youcode.rentalhive.model.dto.dosssierReservationDto.response.EquipmentReservationResponseDto;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentResponseDto;
import ma.youcode.rentalhive.model.dto.equipmentMatriculeDto.EquipmentMatriculeDto;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;
import ma.youcode.rentalhive.model.mapper.equipmentDtoMapper.EquipmentDtoMapper;
import ma.youcode.rentalhive.model.mapper.reservationDtoMapper.ReservationDtoMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DossierResponseDtoMapper {

    public static DossierResponseDto toDossierResponseDto(List<List<DossierReservation>> dossierReservation){
        DossierResponseDto dossierResponseDto = new DossierResponseDto();
        ReservationDto reservationDto = ReservationDtoMapper.toReservationDto(dossierReservation.get(0).get(1).getReservation());
        dossierResponseDto.setReservation(reservationDto);
        Set<EquipmentReservationResponseDto> equipmentReservationResponseDtoSet = new HashSet<>();
        dossierReservation.forEach(dr ->{
            Set<EquipmentMatriculeDto> equipmentMatricules = new HashSet<>();
            dr.forEach(drEqp->{
                EquipmentMatriculeDto equipmentMatricule = new EquipmentMatriculeDto(drEqp.getEquipmentMatricule().getMatricule());
                equipmentMatricules.add(equipmentMatricule);
            });
            EquipmentResponseDto equipmentResponseDto = EquipmentDtoMapper.toEquipmentDto(dr.get(0).getEquipmentMatricule().getEquipment());
            EquipmentReservationResponseDto equipmentReservationResponseDto
                    =new EquipmentReservationResponseDto(
                    dr.get(0).getStartDate(),
                    dr.get(0).getEndDate(),
                    dr.get(0).getQuantityRequested(),
                    dr.get(0).getQuantityAvailable(),
                    equipmentResponseDto,
                    dr.get(0).getPriceTotalForEquipment(),
                    equipmentMatricules
                    );
            equipmentReservationResponseDtoSet.add(equipmentReservationResponseDto);

        });
        dossierResponseDto.setEquipmentForReservation(equipmentReservationResponseDtoSet);
        return dossierResponseDto;
    }
}
