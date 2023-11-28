package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.domaine.entities.Reservation;
import ma.youcode.rentalhive.model.dto.dosssierReservationDto.DossierRequestDto;
import ma.youcode.rentalhive.model.dto.dosssierReservationDto.DossierResponseDTO;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;

public interface ReservationService {
    public Reservation CreateReservation(Reservation reservation);
    public void deleteReservation(Long id);
}
