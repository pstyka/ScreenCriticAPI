package pawel.stringframework.screencriticapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pawel.stringframework.screencriticapi.entities.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findAllByMovieCategoryId(String movieCategoryId);
}
