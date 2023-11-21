package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> searchCategory(Long id);
    void validateCategory(Category category);
    void validatioCategoryId(Long category_id);
}
