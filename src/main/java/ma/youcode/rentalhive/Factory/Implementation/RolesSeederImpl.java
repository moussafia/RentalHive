package ma.youcode.rentalhive.Factory.Implementation;

import ma.youcode.rentalhive.Factory.RoleSeeder;
import ma.youcode.rentalhive.dao.RoleDao;
import ma.youcode.rentalhive.model.domaine.entities.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolesSeederImpl implements RoleSeeder {
    private RoleDao roleDao;

    public RolesSeederImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void createRoleSeeder() {
        List<String> roles = List.of("Responsable de stock","Admin", "client");
        roles.forEach(r -> roleDao.save(new Role().builder().name(r).build()));
    }
}
