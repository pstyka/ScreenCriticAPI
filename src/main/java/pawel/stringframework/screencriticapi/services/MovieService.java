package pawel.stringframework.screencriticapi.services;

import pawel.stringframework.screencriticapi.model.MovieDTO;

import java.util.List;

public interface MovieService {

    List<MovieDTO> listMovies();
}
