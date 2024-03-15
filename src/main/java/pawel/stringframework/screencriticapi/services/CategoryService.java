package pawel.stringframework.screencriticapi.services;

import pawel.stringframework.screencriticapi.model.CategoryDTO;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CategoryService {
    public List<CategoryDTO> listCategories();
    public Map<String, String> categoryMap();
}
