package pizza_ordering.service;

import java.util.List;
import pizza_ordering.entity.Categories;

public interface CategoryService {

    Categories createCategory(Categories category);

    List<Categories> getAllCategories();

    void deleteCategory(Long categoryId);

}
