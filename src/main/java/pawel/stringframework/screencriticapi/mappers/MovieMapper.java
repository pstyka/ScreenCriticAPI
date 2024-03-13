package pawel.stringframework.screencriticapi.mappers;

import org.mapstruct.Mapper;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.MovieDTO;

@Mapper
public interface MovieMapper {

    Movie movieDTOToMovie(MovieDTO movieDTO);
    MovieDTO movieToMovieDTO(Movie movie);
}
