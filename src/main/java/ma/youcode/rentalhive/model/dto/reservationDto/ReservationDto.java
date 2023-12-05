package ma.youcode.rentalhive.model.dto.reservationDto;

import lombok.*;
import ma.youcode.rentalhive.model.domaine.enums.Status;
import ma.youcode.rentalhive.model.dto.userDto.UserDto;

import java.io.Serializable;

@Builder
public record ReservationDto(
        Long id,
        String location,
        UserDto user,
        Float price_calculate,
        Status status,
        String currency) implements Serializable {

}