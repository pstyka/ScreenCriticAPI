package pawel.stringframework.screencriticapi.mappers;

import org.mapstruct.Mapper;
import pawel.stringframework.screencriticapi.entities.Category;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.CategoryDTO;
import pawel.stringframework.screencriticapi.model.MovieDTO;

@Mapper
public interface CategoryMapper {
    Category categoryDTOToCategory(CategoryDTO categoryDTO);
    CategoryDTO categoryToCategoryDTO(Category category);
}
