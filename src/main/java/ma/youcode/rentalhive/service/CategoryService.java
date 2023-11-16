package ma.youcode.rentalhive.service;

import ma.youcode.rentalhive.entities.Category;

public interface CategoryService {
    Category searchCategory(Long id);
    void validateCategory(Category category);
}
