package pavlov24.deverb.repository;

import org.springframework.data.repository.CrudRepository;
import pavlov24.deverb.domain.Statistics;

public interface StatisticsRepository extends CrudRepository<Statistics, Long> {
}
