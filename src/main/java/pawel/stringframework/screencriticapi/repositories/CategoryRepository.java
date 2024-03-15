package pawel.stringframework.screencriticapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pawel.stringframework.screencriticapi.entities.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
