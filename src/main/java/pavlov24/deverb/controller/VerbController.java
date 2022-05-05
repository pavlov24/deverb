package pavlov24.deverb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pavlov24.deverb.domain.Verb;
import pavlov24.deverb.repository.VerbRepository;

@Controller
public class VerbController {

    @Autowired
    private VerbRepository verbRepository;

    @GetMapping("/word/{word}")
    public String list(Model model, @PathVariable String word) {
        Verb verb = verbRepository.findByValue(word);
        if (verb != null) {
            model.addAttribute("verb", verb );
            return "word";
        } else {
            return "404";
        }
    }
}
