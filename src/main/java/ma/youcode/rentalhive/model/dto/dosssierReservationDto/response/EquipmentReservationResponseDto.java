package ma.youcode.rentalhive.model.dto.dosssierReservationDto.response;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentResponseDto;
import ma.youcode.rentalhive.model.dto.equipmentMatriculeDto.EquipmentMatriculeDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


public record EquipmentReservationResponseDto(
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer quantity,
        Integer quantityAvailable,
        EquipmentResponseDto equipment,
        Float priceTotal,
        Set<EquipmentMatriculeDto> equipmentMatricules
        
) implements Serializable {


}
