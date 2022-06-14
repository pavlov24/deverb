package pavlov24.deverb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pavlov24.deverb.domain.Verb;
import pavlov24.deverb.repository.VerbRepository;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private VerbRepository verbRepository;

    @GetMapping("/search/{query}")
    public List<Verb> search(@PathVariable String query) {
        return verbRepository.findByValueContaining(query);
    }
}
