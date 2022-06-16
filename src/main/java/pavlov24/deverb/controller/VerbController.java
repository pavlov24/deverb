package pavlov24.deverb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pavlov24.deverb.domain.Client;
import pavlov24.deverb.domain.Verb;
import pavlov24.deverb.repository.ClientRepository;
import pavlov24.deverb.repository.VerbRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class VerbController {

    @Autowired
    private VerbRepository verbRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/word/{word}")
    public String list(Model model, @PathVariable String word, Authentication auth) {
        Verb verb = verbRepository.findByValue(word);
        if (verb != null) {
            model.addAttribute("verb", verb );
            long views = verb.getStatistics().getViews();
            verb.getStatistics().setViews(views+1);
            verbRepository.save(verb);

            if (auth != null) {
                UserDetails userDetails = (UserDetails) auth.getPrincipal();
                if (userDetails instanceof Client) {
                    Client client = clientRepository.findByIdJoinFetch(((Client) userDetails).getId());
                    model.addAttribute("follow", verb.getFollowers().contains(client));
                } else {
                    model.addAttribute("follow", false);
                }
            } else {
                model.addAttribute("follow", false);
            }

            return "word";
        } else {
            return "404";
        }
    }


}
