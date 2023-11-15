package ma.youcode.rentalhive.dao;

import ma.youcode.rentalhive.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {
}