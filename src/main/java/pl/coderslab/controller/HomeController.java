package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.PasswordService;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/register")
    public String registerNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "form/userRegister";
    }

    @PostMapping("/register")
    public String saveNewUser(@Valid User user, BindingResult result) {
        if(result.hasErrors()) return "form/userRegister";
        if(userRepository.findUserByEmail(user.getEmail()) == null){
            user.setHashPassword(PasswordService.makeHashed(user.getHashPassword()));
            userRepository.save(user);
            return "home";
        } else return "form/userRegister";
    }
}
