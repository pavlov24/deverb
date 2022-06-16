package pavlov24.deverb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pavlov24.deverb.domain.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findByName(String name);
    Boolean existsByName(String name);
    @Query("select c from Client c join fetch c.verbs where c.id = :id")
    Client findByIdJoinFetch(@Param("id") Long id);

}
