package ma.youcode.rentalhive.web.controller;

import ma.youcode.rentalhive.model.domaine.entities.DossierReservation;
import ma.youcode.rentalhive.model.domaine.entities.Reservation;
import ma.youcode.rentalhive.model.dto.dosssierReservationDto.request.DossierRequestDto;
import ma.youcode.rentalhive.model.mapper.dossierRerservationDtoMapper.DossierRequestDtoMapper;
import ma.youcode.rentalhive.service.DossierReservationService;
import ma.youcode.rentalhive.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/reservation")

public class ReservationController {
    ReservationService reservationService;
    DossierReservationService dossierReservationService;

    public ReservationController(ReservationService reservationService,
                                 DossierReservationService dossierReservationService) {
        this.reservationService = reservationService;
        this.dossierReservationService = dossierReservationService;
    }
    @PostMapping
    public List<List<DossierReservation>> saveReservation(@RequestBody DossierRequestDto dossierRequestDto){
        Set<DossierReservation> dossierReservation = DossierRequestDtoMapper.toSetDossierReservation(dossierRequestDto);
        Reservation reservation = new Reservation().builder().Location(dossierRequestDto.getLocation()).build();
        Reservation reservationSaved = reservationService.CreateReservation(reservation);
        List<List<DossierReservation>> dossierReservationList = new ArrayList<>();
        dossierReservation.forEach(dr -> {
            dr.setReservation(reservationSaved);
            List<DossierReservation> dossierReservationSaved = dossierReservationService.createDossierReservation(dr);
            dossierReservationList.add(dossierReservationSaved);
        });

        return dossierReservationList;

    }
}
