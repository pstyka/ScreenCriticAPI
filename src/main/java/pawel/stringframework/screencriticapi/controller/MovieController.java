package pawel.stringframework.screencriticapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.services.MovieService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private static final String MOVIE_PATH = "/api/v1/movie";
    private static final String MOVIE_PATH_ID = MOVIE_PATH + "/{movieId}";
    private final MovieService movieService;


    @GetMapping(value = MOVIE_PATH)
    public List<MovieDTO> listMovies(){
        return movieService.listMovies();
    }

    @GetMapping(value = MOVIE_PATH_ID)
    public MovieDTO getMovieById(@PathVariable("movieId") UUID movieId){
        return movieService.getMovieById(movieId).orElseThrow(NotFoundException::new);
    }



}
