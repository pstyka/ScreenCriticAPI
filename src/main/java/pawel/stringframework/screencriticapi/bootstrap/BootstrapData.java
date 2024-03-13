package pawel.stringframework.screencriticapi.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.apache.commons.lang3.StringUtils;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.Category;
import pawel.stringframework.screencriticapi.model.MovieCSVRecord;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.repositories.MovieRepository;
import pawel.stringframework.screencriticapi.services.MovieCSVService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final MovieCSVService movieCSVService;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        //loadMovieData();
        loadCsvData();
    }
    private void loadMovieData(){
        if(movieRepository.count()==0){
            Movie m1 = Movie.builder()
                    .id(UUID.randomUUID())
                    .movieName("Oppenheimer")
                    .movieCategory(Category.ACTION)
                    .movieDirector("Cristopher Nolan")
                    .movieDescription("Biography of Oppenheimer")
                    .movieReleaseDate(2023)
                    .version(1)
                    .movieAverageRating(8.8f)
                    .build();
            Movie m2 = Movie.builder()
                    .id(UUID.randomUUID())
                    .movieName("Jurassic Park")
                    .movieCategory(Category.ACTION)
                    .movieDirector("Steven Spielberg")
                    .movieDescription("Movie about dinosaurs in real world")
                    .movieReleaseDate(1993)
                    .version(1)
                    .movieAverageRating(6.6f)
                    .build();

            movieRepository.save(m1);
            movieRepository.save(m2);
        }
    }
    private void loadCsvData() throws FileNotFoundException {
        if(movieRepository.count()< 10){
            File file = ResourceUtils.getFile("classpath:csvdata/movies.csv");
            List<MovieCSVRecord> records = movieCSVService.convertCSV(file);

            records.forEach(movieCSVRecord ->
            {
                Category category = switch (movieCSVRecord.getMovie_category()){
                    //ACTION, ADVENTURE, ANIMATION, COMEDY, CRIME, DOCUMENTARY, DRAMA, FAMILY, FANTASY,
                    //    HISTORY, HORROR, MUSIC, MYSTERY, ROMANCE, SCIENCE_FICTION, THRILLER, WAR, WESTERN
                    case "ACTION" -> Category.ACTION;
                    case "ADVENTURE" -> Category.ADVENTURE;
                    case "ANIMATION" -> Category.ANIMATION;
                    case "COMEDY" -> Category.COMEDY;
                    case "CRIME" -> Category.CRIME;
                    case "DOCUMENTARY" -> Category.DOCUMENTARY;
                    case "DRAMA" -> Category.DRAMA;
                    case "FAMILY" -> Category.FAMILY;
                    case "FANTASY" -> Category.FANTASY;
                    case "HISTORY" -> Category.HISTORY;
                    case "HORROR" -> Category.HORROR;
                    case "MUSIC" -> Category.MUSIC;
                    case "MYSTERY" -> Category.MYSTERY;
                    case "ROMANCE" -> Category.ROMANCE;
                    case "SCIENCE_FICTION" -> Category.SCIENCE_FICTION;
                    case "THRILLER" -> Category.THRILLER;
                    case "WAR" -> Category.WAR;
                    case "WESTERN" -> Category.WESTERN;
                    default -> Category.ADVENTURE;
                };
                movieRepository.save(Movie.builder()
                        .movieName(StringUtils.abbreviate(movieCSVRecord.getMovie_name(),50))
                                .movieCategory(category)
                                .movieAverageRating(movieCSVRecord.getMovie_avg_rating())
                                .movieReleaseDate(movieCSVRecord.getMovie_release_date())
                                .movieDirector(StringUtils.abbreviate(movieCSVRecord.getMovie_director(),40))
                                .movieDescription(StringUtils.abbreviate(movieCSVRecord.getMovie_description(),300))
                        .build());
            });


        }
    }




}
