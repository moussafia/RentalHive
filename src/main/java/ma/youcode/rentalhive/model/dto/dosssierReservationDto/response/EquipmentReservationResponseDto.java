package ma.youcode.rentalhive.model.dto.dosssierReservationDto.response;

import lombok.Data;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class EquipmentReservationResponseDto implements Serializable {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer quantity;
    private Integer quantityAvailable;
    private EquipmentDto equipmentDto;
    private Set<EquipmentReservationResponseDto> equipmentReservationDtoSet;


}
