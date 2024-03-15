package pawel.stringframework.screencriticapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pawel.stringframework.screencriticapi.entities.Category;
import pawel.stringframework.screencriticapi.mappers.CategoryMapper;
import pawel.stringframework.screencriticapi.model.CategoryDTO;
import pawel.stringframework.screencriticapi.repositories.CategoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public List<CategoryDTO> listCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, String> categoryMap() {
        Map<String, String> map = new HashMap<>();
        for(CategoryDTO categoryDTO: listCategories()){
            map.put(categoryDTO.getName(), String.valueOf(categoryDTO.getId()));
        }
        return map;
    }
}
