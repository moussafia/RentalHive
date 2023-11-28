package ma.youcode.rentalhive.model.mapper.reservationDtoMapper;

import ma.youcode.rentalhive.model.domaine.entities.Reservation;
import ma.youcode.rentalhive.model.domaine.enums.Status;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;
import ma.youcode.rentalhive.model.dto.userDto.UserDto;
import ma.youcode.rentalhive.model.mapper.userMapper.UserDtoMapper;

public class ReservationDtoMapper {
    public static void toReservation(ReservationDto reservationDto){
//        Reservation reservation = new Reservation().builder()
//                .status(reservationDto.status()).Location(reservationDto.location())
//                .build();
//        return reservation;
//    }
//    public static ReservationDto toReservationDto(Reservation reservation){
//        ReservationDto reservationDto = ReservationDto.builder()
//                .id(reservation.getId())
//                .user(UserDtoMapper.toUserDto(reservation.getUser()))
//                .price_calculate(reservation.getPrice())
//                .location(reservation.getLocation())
//                .status(reservation.getStatus())
//                .build();
//        return reservationDto;
    }
}
