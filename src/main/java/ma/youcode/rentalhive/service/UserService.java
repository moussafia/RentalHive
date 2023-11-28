package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.model.domaine.entities.User;
import ma.youcode.rentalhive.model.dto.userDto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {
    User getUserById(Long id);
}
