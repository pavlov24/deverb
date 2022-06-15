package pavlov24.deverb.repository;

import org.springframework.data.repository.CrudRepository;
import pavlov24.deverb.domain.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findByName(String name);
    Boolean existsByName(String name);

}
