package pavlov24.deverb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pavlov24.deverb.domain.Client;
import pavlov24.deverb.repository.ClientRepository;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public String client(Model model, Authentication auth) {

        if (auth != null) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            if (userDetails instanceof Client) {
                Client client = clientRepository.findByIdJoinFetch(((Client) userDetails).getId());
                model.addAttribute("client", client);
            } else {
                return "404";
            }
        } else {
            return "404";
        }

        return "client";
    }
}
