package ma.youcode.rentalhive.model.dto.dosssierReservationDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class EquipmentReservationDto implements Serializable {
    private Long equipment_id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer quantity;
    private Integer quantityAvailable;

}
