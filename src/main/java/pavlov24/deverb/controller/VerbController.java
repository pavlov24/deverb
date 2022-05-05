package pavlov24.deverb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VerbController {

    @GetMapping("/word/{word}")
    public String list(Model model, @PathVariable String word) {
        model.addAttribute("verb", word);
        return "word";
    }
}
