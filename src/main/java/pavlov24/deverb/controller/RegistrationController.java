package pavlov24.deverb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pavlov24.deverb.domain.Client;
import pavlov24.deverb.domain.Role;
import pavlov24.deverb.repository.ClientRepository;

import java.util.regex.Pattern;


@Controller
public class RegistrationController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    @GetMapping("/registration")
    public String getForm(Model model) {
        model.addAttribute("userForm", new Client());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestBody MultiValueMap<String, String> formData, Model model) {

        String name = formData.get("name").get(0);
        String password = formData.get("password").get(0);
        String passwordConfirm = formData.get("passwordConfirm").get(0);

        logger.info("Receive user for registration {} ", formData);

        boolean hasError = false; // флаг, была ли найдена ошибка

        if (name == null) {
            model.addAttribute("nameError", "Имя - обязательное поле");
            hasError = true;
        }

        if (password == null) {
            model.addAttribute("passwordError", "Пароль - обязательное поле");
            hasError = true;
        }
        if (passwordConfirm == null) {
            model.addAttribute("passwordConfirmError",  "Повтор пароля - обязательное поле");
            hasError = true;
        }
        if (password != null) {
            if (password.length() < 8) {
                model.addAttribute("passwordError",  "Длина пароля должна быть 8 и более символов");
                hasError = true;
            }
        }
        if (password != null && passwordConfirm != null) {
            if (!password.equals(passwordConfirm)) {
                model.addAttribute("passwordConfirmError",  "Введенные пароли должны совпадать");
                hasError = true;
            }
        }

        if (hasError) { //если есть хотя бы одна ошибка, возращаем форму обратно
            model.addAttribute("hasError", true);
            model.addAttribute("name", name);
            model.addAttribute("password", password);
            model.addAttribute("passwordConfirm", passwordConfirm);

            return "registration";
        }

        Client client = new Client(0L, name, encoder.encode(password), Role.ROLE_USER);


        if (clientRepository.existsByName(name)){ // если пользователь уже существует
            model.addAttribute("emailAlreadyExistError", "Пользователь с таким именем уже существует");
            model.addAttribute("hasError", true);
            return "registration";
        } else {
            clientRepository.save(client);
        }

        return "redirect:/";
    }
}
