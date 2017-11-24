package cz.fi.muni.pa165.facade;

import java.util.List;

import com.frenchies.tennisclub.dto.CategoryCreateDTO;
import com.frenchies.tennisclub.dto.CategoryDTO;
public interface CategoryFacade
{
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long id);

    Long createCategory(CategoryCreateDTO categoryCreateDTO);
}
