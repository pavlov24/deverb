package pavlov24.deverb.repository;

import org.springframework.data.repository.CrudRepository;
import pavlov24.deverb.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
