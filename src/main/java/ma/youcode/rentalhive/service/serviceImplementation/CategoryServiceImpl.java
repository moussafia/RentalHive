package ma.youcode.rentalhive.service.serviceImplementation;

import ma.youcode.rentalhive.dao.CategoryDao;
import ma.youcode.rentalhive.entities.Category;
import ma.youcode.rentalhive.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    public CategoryServiceImpl() {
    }

    @Override
    public Optional<Category> searchCategory(Long id) {
        validatioCategoryId(id);
        return categoryDao.findById(id);
    }
    @Override
    public void validatioCategoryId(Long category_id){
        if(category_id == null)
            throw  new IllegalArgumentException("category id should not be null");
        if(category_id.toString().isBlank())
            throw  new IllegalArgumentException("category id should not be blank");
        if(category_id.toString().isEmpty())
            throw  new IllegalArgumentException("category id should not be empty");
    }

    @Override
    public void validateCategory(Category category) {

    }
}
