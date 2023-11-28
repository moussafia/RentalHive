package ma.youcode.rentalhive.model.dto.dosssierReservationDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@Setter
public class DossierResponseDTO implements Serializable {
    private ReservationDto reservationDTO;
    private Set<EquipmentReservationDto> equipmentReservationDtoList;
}
