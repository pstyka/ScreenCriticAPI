package pawel.stringframework.screencriticapi.services;

import pawel.stringframework.screencriticapi.model.MovieDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {

    List<MovieDTO> listMovies();
    Optional<MovieDTO> getMovieById(UUID id);


}
