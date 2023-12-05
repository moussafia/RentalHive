package ma.youcode.rentalhive.model.dto.dosssierReservationDto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter @Setter
public class DossierRequestDto implements Serializable {
    private String location;
    private String currency;
    private Set<EquipmentReservationRequestDto> equipmentForReservation;

}
