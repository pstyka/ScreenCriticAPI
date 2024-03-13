package pawel.stringframework.screencriticapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.mappers.MovieMapper;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.repositories.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class MovieServiceJPA implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    @Override
    public List<MovieDTO> listMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::movieToMovieDTO)
                .collect(Collectors.toList());
    }
}
