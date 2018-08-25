package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/allTweets")
    public String displayAllTweets(Model model) {
        List<Tweet> tweets = tweetRepository.findAll();
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @RequestMapping("/allTweetsCurrentUser")
    public String displayAllTweetsCurrentUser(HttpServletRequest request, Model model) {
        HttpSession sess = request.getSession();
        Integer id = ((User)sess.getAttribute("currentUser")).getId();
        User currentUser = userRepository.findOne(id);
        List<Tweet> tweets = tweetRepository.findAllByUser(currentUser);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @RequestMapping("/allTweetsSpecificUser")
    public String displayAllTweetsSpecificUser(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("value"));
        List<Tweet> tweets = tweetRepository.findAllByUserId(id);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }
}
