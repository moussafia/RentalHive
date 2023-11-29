package ma.youcode.rentalhive.model.dto.dosssierReservationDto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class DossierRequestDto implements Serializable {
    private String location;
    private Set<EquipmentReservationRequestDto> equipmentForReservation;

}
