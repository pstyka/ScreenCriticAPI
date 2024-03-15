package pawel.stringframework.screencriticapi.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.apache.commons.lang3.StringUtils;
import pawel.stringframework.screencriticapi.entities.Category;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.MovieCSVRecord;
import pawel.stringframework.screencriticapi.repositories.CategoryRepository;
import pawel.stringframework.screencriticapi.repositories.MovieRepository;
import pawel.stringframework.screencriticapi.services.CategoryService;
import pawel.stringframework.screencriticapi.services.MovieCSVService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final MovieCSVService movieCSVService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCsvData();
    }

    private void loadCategories(){
        List<String> categoryNames = Arrays.asList(
                "ACTION", "ADVENTURE", "ANIMATION", "COMEDY", "CRIME",
                "DOCUMENTARY", "DRAMA", "FAMILY", "FANTASY", "HISTORY",
                "HORROR", "MUSIC", "MYSTERY", "ROMANCE", "SCIENCE FICTION",
                "THRILLER", "WAR", "WESTERN"
        );

        for (String categoryName : categoryNames) {
            Category category = new Category();
            category.setId(UUID.randomUUID());
            category.setName(categoryName);
            categoryRepository.save(category);
        }
    }
    private void loadCsvData() throws FileNotFoundException {
        if(movieRepository.count()< 10){
            File file = ResourceUtils.getFile("classpath:csvdata/movies.csv");
            List<MovieCSVRecord> records = movieCSVService.convertCSV(file);


            records.forEach(movieCSVRecord ->
            {
                String categoryName = movieCSVRecord.getMovie_category();
                String categoryId = categoryService.categoryMap().get(categoryName);
                movieRepository.save(Movie.builder()
                        .movieName(StringUtils.abbreviate(movieCSVRecord.getMovie_name(),50))
                                .movieCategoryId(categoryId)
                                .movieAverageRating(movieCSVRecord.getMovie_avg_rating())
                                .movieReleaseDate(movieCSVRecord.getMovie_release_date())
                                .movieDirector(StringUtils.abbreviate(movieCSVRecord.getMovie_director(),40))
                                .movieDescription(StringUtils.abbreviate(movieCSVRecord.getMovie_description(),300))
                        .build());
            });


        }
    }




}
