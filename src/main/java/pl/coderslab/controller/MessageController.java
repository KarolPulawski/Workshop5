package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @ModelAttribute("users")
    private List<User> users() {
        return userRepository.findAll();
    }

    @RequestMapping("/messages")
    public String displayMessages() {
        return "messages";
    }

    @RequestMapping("/send")
    public String goIntoMessagePanel(Model model) {
        Message message = new Message();
        model.addAttribute("message", message);
        return "form/messageCreate";
    }

    @PostMapping("/send")
    public String sendMessage(HttpServletRequest request, @ModelAttribute Message message) {
        HttpSession sess = request.getSession();
        User sender = (User)sess.getAttribute("currentUser");
        message.setSender(sender);
        messageRepository.saveAndFlush(message);
        return "messages";
    }

}
