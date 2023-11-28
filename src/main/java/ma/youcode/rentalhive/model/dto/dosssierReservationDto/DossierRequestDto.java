package ma.youcode.rentalhive.model.dto.dosssierReservationDto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class DossierRequestDto implements Serializable {
    private String location;
    private Set<EquipmentReservationDto> equipmentForReservation;

}
