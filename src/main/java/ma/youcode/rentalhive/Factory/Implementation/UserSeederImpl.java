package ma.youcode.rentalhive.Factory.Implementation;

import ma.youcode.rentalhive.Factory.UserSeeder;
import ma.youcode.rentalhive.dao.UserDao;
import ma.youcode.rentalhive.model.domaine.entities.Role;
import ma.youcode.rentalhive.model.domaine.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserSeederImpl implements UserSeeder {
    private UserDao userDao;

    public UserSeederImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUserSeeder() {
        User user1 = new User().builder().user_name("mohammed").Email("mohammed@gmail.com")
                .password(null).role(new Role().builder().id(1L).build()).build();
        User user2 = new User().builder().user_name("client1")
                .Email("client1@gmail.com").password(null).role(new Role().builder().id(3L).build()).build();
        User user3 = new User().builder().user_name("client2").Email("client2@gmail.com")
                .password(null).role(new Role().builder().id(3L).build()).build();
        List<User> userList = List.of(user1, user2, user3);
        userList.forEach(u -> userDao.save(u));
    }
}
