package ma.youcode.rentalhive.Factory.Implementation;

import ma.youcode.rentalhive.Factory.CategorySeeder;
import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.model.domaine.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategorySeederImpl implements CategorySeeder {
    private CategoryDao categoryDao;

    public CategorySeederImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void CreateCategorySeeder() {
        List<String> category = List.of("Fondations","Structure","Isolation","Toiture");
        category.forEach(c -> categoryDao.save(new Category().builder().name(c)
                .build()));
    }
}
