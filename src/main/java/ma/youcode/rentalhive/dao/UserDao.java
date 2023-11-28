package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.model.domaine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
