package ma.youcode.rentalhive.model.dto.dosssierReservationDto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;

import java.io.Serializable;
import java.util.Set;

@Getter
@Builder
@Setter
public class DossierResponseDto implements Serializable {
    private ReservationDto reservationDTO;
    private Set<EquipmentReservationResponseDto> equipmentReservationDtoList;
}
