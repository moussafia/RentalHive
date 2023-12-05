package ma.youcode.rentalhive.model.dto.dosssierReservationDto.response;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ma.youcode.rentalhive.model.dto.equipmentDto.EquipmentDto;
import ma.youcode.rentalhive.model.dto.equipmentMatriculeDto.EquipmentMatriculeDto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


public record EquipmentReservationResponseDto(
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer quantity,
        Integer quantityAvailable,
        EquipmentDto equipment,
        Float priceTotal,
        Set<EquipmentMatriculeDto> equipmentMatricules
        
) implements Serializable {


}
