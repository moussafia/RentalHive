package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.domaine.entities.Reservation;

public interface ReservationService {
    public Reservation CreateReservation(Reservation reservation);
    public void deleteReservation(Long id);
}
