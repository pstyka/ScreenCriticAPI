package pawel.stringframework.screencriticapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pawel.stringframework.screencriticapi.model.CategoryDTO;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.services.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private static final String CATEGORY_PATH = "/api/v1/categories" ;

    private final CategoryService categoryService;
    @GetMapping(value = CATEGORY_PATH)
    public List<CategoryDTO> listCategories(){
        return categoryService.listCategories();
    }
}
