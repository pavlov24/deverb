package pavlov24.deverb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pavlov24.deverb.domain.Client;
import pavlov24.deverb.domain.Verb;
import pavlov24.deverb.repository.ClientRepository;
import pavlov24.deverb.repository.VerbRepository;

import java.util.Optional;

@Controller
public class BookmarkController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    VerbRepository verbRepository;

    @GetMapping("/bookmark/add/{id}")
    @ResponseBody
    public int bookmark(@PathVariable Long id, Authentication authentication) {
        if (authentication != null) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails instanceof Client) {
                Client client = clientRepository.findByIdJoinFetch(((Client) userDetails).getId());
                Optional<Verb> optional = verbRepository.findById(id);
                if (optional.isPresent()) {
                    Verb verb = optional.get();
                    verb.addFollower(client);
                    verbRepository.save(verb);
                    clientRepository.save(client);
                    return verb.getFollowers().size();
                }
            }
        }
        return -1;
    }

    @GetMapping("/bookmark/remove/{id}")
    @ResponseBody
    public int unbookmark(@PathVariable Long id, Authentication authentication) {
        if (authentication != null) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            if (userDetails instanceof Client) {
                Client client = clientRepository.findByIdJoinFetch(((Client) userDetails).getId());
                Optional<Verb> optional = verbRepository.findById(id);
                if (optional.isPresent()) {
                    Verb verb = optional.get();
                    verb.removeFollower(client);
                    verbRepository.save(verb);
                    clientRepository.save(client);
                    return verb.getFollowers().size();
                }
            }
        }
        return -1;
    }

}
