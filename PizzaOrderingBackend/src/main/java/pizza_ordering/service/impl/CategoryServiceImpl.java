package pizza_ordering.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pizza_ordering.repository.CategoryRepository;
import pizza_ordering.service.CategoryService;
import pizza_ordering.entity.Categories;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Categories createCategory(Categories category){
        return categoryRepository.save(category);
    }

    @Override
    public List<Categories> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }




}
