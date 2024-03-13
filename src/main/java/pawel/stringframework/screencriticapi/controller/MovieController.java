package pawel.stringframework.screencriticapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.repositories.MovieRepository;
import pawel.stringframework.screencriticapi.services.MovieService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private static final String MOVIE_PATH = "/api/v1/movie";
    private final MovieService movieService;


    @GetMapping(value = MOVIE_PATH)
    public List<MovieDTO> listMovies(){
        return movieService.listMovies();
    }

}
