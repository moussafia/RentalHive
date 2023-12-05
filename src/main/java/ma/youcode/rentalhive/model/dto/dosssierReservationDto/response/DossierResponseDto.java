package ma.youcode.rentalhive.model.dto.dosssierReservationDto.response;

import lombok.*;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;

import java.io.Serializable;
import java.util.Set;

@Getter
@Builder
@Setter @AllArgsConstructor @NoArgsConstructor
public class DossierResponseDto implements Serializable {
    private ReservationDto reservation;
    private Set<EquipmentReservationResponseDto> equipmentForReservation;
}
