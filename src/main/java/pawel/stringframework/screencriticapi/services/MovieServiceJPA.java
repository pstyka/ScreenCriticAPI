package pawel.stringframework.screencriticapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.mappers.MovieMapper;
import pawel.stringframework.screencriticapi.model.MovieDTO;
import pawel.stringframework.screencriticapi.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class MovieServiceJPA implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    @Override
    public List<MovieDTO> listMovies( ) {

        return movieRepository.findAll().stream()
                .map(movieMapper::movieToMovieDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDTO> getMovieById(UUID id) {
        return Optional.ofNullable(movieMapper.movieToMovieDTO(movieRepository.findById(id)
                .orElse(null)));
    }

    @Override
    public List<Movie> getMovieByCategoryId(String id) {
        return movieRepository.findAllByMovieCategoryId(id);
    }


}
