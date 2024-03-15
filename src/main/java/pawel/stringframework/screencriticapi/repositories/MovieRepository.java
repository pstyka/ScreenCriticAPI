package pawel.stringframework.screencriticapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pawel.stringframework.screencriticapi.entities.Movie;
import pawel.stringframework.screencriticapi.model.Category;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

    List<Movie> findAllByMovieCategory(Category category);

}
