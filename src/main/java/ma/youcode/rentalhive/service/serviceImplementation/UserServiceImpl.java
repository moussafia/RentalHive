package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.UserDao;
import ma.youcode.rentalhive.model.domaine.entities.User;
import ma.youcode.rentalhive.model.dto.userDto.UserDto;
import ma.youcode.rentalhive.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }
}
