package pavlov24.deverb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pavlov24.deverb.domain.Verb;

import java.util.List;
import java.util.Optional;

public interface VerbRepository extends CrudRepository<Verb, Long> {

    @Query("select v from Verb v join fetch v.followers where v.id = :id")
    Optional<Verb> findByIdJoinFollowers(@Param("id") Long id);

    Verb findByValue(String value);

    @Query("select v from Verb v where v.value like %:value%")
    List<Verb> findByValueContaining(@Param("value") String value);
}
