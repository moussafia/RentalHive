package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.ReservationDao;
import ma.youcode.rentalhive.dao.UserDao;
import ma.youcode.rentalhive.model.domaine.entities.Reservation;
import ma.youcode.rentalhive.model.domaine.entities.User;
import ma.youcode.rentalhive.model.domaine.enums.Status;
import ma.youcode.rentalhive.model.dto.reservationDto.ReservationDto;
import ma.youcode.rentalhive.model.dto.userDto.UserDto;
import ma.youcode.rentalhive.model.mapper.reservationDtoMapper.ReservationDtoMapper;
import ma.youcode.rentalhive.service.ReservationService;
import ma.youcode.rentalhive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao;
    private UserService userService;

    public ReservationServiceImpl(ReservationDao reservationDao,
                                  UserService userService) {
        this.reservationDao = reservationDao;
        this.userService = userService;
    }

    @Override
    public Reservation CreateReservation(Reservation reservation) {
        reservation.setStatusClient(Status.PENDING);
        User user = userService.getUserById(Math.random() > 0.5 ? 2L : 3L);
        if(user!=null) reservation.setUser(user);
        return reservationDao.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {

    }
}
