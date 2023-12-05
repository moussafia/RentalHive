package ma.youcode.rentalhive.model.mapper.categoryDtoMapper;

import ma.youcode.rentalhive.model.domaine.entities.Category;
import ma.youcode.rentalhive.model.dto.categoryDto.CategoryDto;

public class CategoryDtoMapper {
    public static CategoryDto toCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto(category.getId(), category.getName());
        return categoryDto;
    }
    public static Category toCategory(CategoryDto categoryDto){
        Category category = Category.builder()
                .id(categoryDto.id())
                .name(categoryDto.name()).build();
        return category;
    }
}
