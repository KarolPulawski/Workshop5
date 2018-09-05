package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.PasswordService;
import pl.coderslab.validator.RegisterValidation;
import pl.coderslab.validator.SignInValidation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }

    @RequestMapping("/home")
    public String homeDisplay() {
        return "home";
    }

    @RequestMapping("/tweeter")
    public String home(HttpServletRequest request) {
        HttpSession sess = request.getSession();
        sess.setAttribute("passCheck", false);
        return "homeLogin";
    }

    @RequestMapping("/register")
    public String registerNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "form/userRegister";
    }

    @PostMapping("/register")
    public String saveNewUser(@Validated(RegisterValidation.class) User user, BindingResult result) {
        if(result.hasErrors()) return "form/userRegister";
        if(userRepository.findUserByEmail(user.getEmail()) == null){
            user.setHashPassword(PasswordService.makeHashed(user.getHashPassword()));
            userRepository.save(user);
            return "redirect:/signIn";
        } else return "form/userRegister";
    }

    @RequestMapping("/signIn")
    public String signInUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "form/userSignIn";
    }

    @PostMapping("/signIn")
    public String signInConfirmation(@Validated(SignInValidation.class) User user, BindingResult result, HttpServletRequest request, Model model) {
        if(result.hasErrors()) return "form/userSignIn";
        User userFromDb  = userRepository.findUserByEmail(user.getEmail());
        HttpSession sess = request.getSession();
        if(userFromDb != null) {
            if(PasswordService.checkPassword(user.getHashPassword(), userFromDb.getHashPassword())){
                sess.setAttribute("passCheck", true);
                sess.setAttribute("currentUser", userFromDb);
                return "home";
            } else {
                model.addAttribute("user", user);
                return "form/userSignIn";
            }
        }
        return "redirect:/signIn";
    }

    @RequestMapping("/test")
    @ResponseBody
    public String testSessPass(HttpServletRequest request) {
        HttpSession sess = null;
        try {
            sess = request.getSession();
            if (sess == null) {
                return "sess is empty";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "sess is empty from catch";
        }
        if((Boolean)sess.getAttribute("passCheck")) return "passwrord is valid";
        else return "password is invalid";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession sess = request.getSession();
        sess.setAttribute("passCheck", false);
        sess.setAttribute("currentUser", null);
        return "homeLogin";
    }

    @RequestMapping("/edit")
    public String userEdit(HttpServletRequest request, Model model) {
        HttpSession sess = request.getSession();
        User user = ((User)sess.getAttribute("currentUser"));
        model.addAttribute("user", user);
        return "form/userEdit";
    }

    @PostMapping("/edit")
    public String saveUserEdit(HttpServletRequest request, @ModelAttribute User user) {
        user.setHashPassword(PasswordService.makeHashed(user.getHashPassword()));
        userRepository.saveAndFlush(user);
        //        em.merge(user);
        return "home";
    }
}
