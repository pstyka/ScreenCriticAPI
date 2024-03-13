package pawel.stringframework.screencriticapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pawel.stringframework.screencriticapi.entities.Movie;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
