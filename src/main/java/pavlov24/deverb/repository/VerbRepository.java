package pavlov24.deverb.repository;

import org.springframework.data.repository.CrudRepository;
import pavlov24.deverb.domain.Verb;

public interface VerbRepository extends CrudRepository<Verb, Long> {

    Verb findByValue(String value);
}
