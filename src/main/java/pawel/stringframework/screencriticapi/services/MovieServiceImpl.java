package pawel.stringframework.screencriticapi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pawel.stringframework.screencriticapi.model.Category;
import pawel.stringframework.screencriticapi.model.MovieDTO;

import java.util.*;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private Map<UUID, MovieDTO> movieMap;

    public MovieServiceImpl() {
        this.movieMap = new HashMap<>();

        MovieDTO m1 = MovieDTO.builder()
                .id(UUID.randomUUID())
                .movieName("Oppenheimer")
                .movieCategory(Category.ACTION)
                .movieDirector("Cristopher Nolan")
                .movieDescription("Biography of Oppenheimer")
                .movieReleaseDate(2023)
                .version(1)
                .movieAverageRating(8.8f)
                .build();
        MovieDTO m2 = MovieDTO.builder()
                .id(UUID.randomUUID())
                .movieName("Jurassic Park")
                .movieCategory(Category.ACTION)
                .movieDirector("Steven Spielberg")
                .movieDescription("Movie about dinosaurs in real world")
                .movieReleaseDate(1993)
                .version(1)
                .movieAverageRating(6.6f)
                .build();

        movieMap.put(m1.getId(),m1);
        movieMap.put(m2.getId(),m2);

    }

    @Override
    public List<MovieDTO> listMovies() {
        return new ArrayList<>(movieMap.values());
    }
}
