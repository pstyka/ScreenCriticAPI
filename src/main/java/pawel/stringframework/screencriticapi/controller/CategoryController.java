package pawel.stringframework.screencriticapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.CategoryDTO;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.services.CategoryService;
import pawel.stringframework.screencriticapi.services.MovieService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private static final String CATEGORY_PATH = "/api/v1/categories" ;
    private static final String CATEGORY_MOVIES_PATH = CATEGORY_PATH + "/{categoryId}";

    private final CategoryService categoryService;
    private final MovieService movieService;
    @GetMapping(value = CATEGORY_PATH)
    public List<CategoryDTO> listCategories(){
        return categoryService.listCategories();
    }

    @GetMapping(value = CATEGORY_MOVIES_PATH)
    public List<Movie> getMoviesByCategoryId(@PathVariable("categoryId") String categoryId){
        return movieService.getMovieByCategoryId(categoryId);
    }
}
