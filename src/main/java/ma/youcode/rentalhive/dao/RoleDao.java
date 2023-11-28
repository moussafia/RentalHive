package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.model.domaine.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
}
