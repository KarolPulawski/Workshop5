package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
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
    public String displayMessages(HttpServletRequest request, Model model) {
        HttpSession sess = request.getSession();
        Integer userId = ((User)sess.getAttribute("currentUser")).getId();
        model.addAttribute("messages", messageRepository.findAllByReceiverId(userId));
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
        return "redirect:messages";
    }

    @RequestMapping("/history")
    public String historyMessage(HttpServletRequest request, Model model) {
        HttpSession sess = request.getSession();
        Integer userId = ((User)sess.getAttribute("currentUser")).getId();
        List<Message> messages = messageRepository.findAllBySenderId(userId);
        model.addAttribute("messages", messages);
        return "history";
    }

    @RequestMapping("/readMessage")
    public String readMessage(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Message message = messageRepository.findById(id);
        model.addAttribute("message", message);
        message.setRead(true);
        messageRepository.save(message);
        return "message";
    }
}
