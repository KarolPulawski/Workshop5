package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.DateService;

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

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/allTweets")
    public String displayAllTweets(Model model) {
        List<Tweet> tweets = tweetRepository.findAllSortByDateCreate();
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @RequestMapping("/allTweetsCurrentUser")
    public String displayAllTweetsCurrentUser(HttpServletRequest request, Model model) {
        HttpSession sess = request.getSession();
        Integer id = ((User)sess.getAttribute("currentUser")).getId();
        User currentUser = userRepository.findOne(id);
        List<Tweet> tweets = tweetRepository.findAllByUserOrderByCreatedDesc(currentUser);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @RequestMapping("/allTweetsSpecificUser")
    public String displayAllTweetsSpecificUser(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("value"));
        List<Tweet> tweets = tweetRepository.findAllByUserIdOrderByCreatedDesc(id);
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @RequestMapping("/addTweet")
    public String addNewTweet(Model model) {
        Tweet tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        return "form/tweetCreate";
    }

    @PostMapping("/addTweet")
    public String saveNewTweet(@ModelAttribute Tweet tweet, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        User currentUser = (User)sess.getAttribute("currentUser");
        tweet.setUser(currentUser);
        tweet.setCreated(DateService.currentTimeToDb());
        tweetRepository.save(tweet);
        return "redirect:/home";
    }

    @RequestMapping("/tweetDetails")
    public String displayTweetDetails(HttpServletRequest request, Model model) {
        Integer id = Integer.parseInt(request.getParameter("tweet_id"));
        Tweet tweet = tweetRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByTweetIdOrderByCreatedDesc(id);
        model.addAttribute("tweet", tweet);
        model.addAttribute("comments", comments);
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        return "specificTweet";
    }

    @PostMapping("/tweetDetails")
    public String addNewComment(@ModelAttribute Comment comment, HttpServletRequest request) {
        Integer tweetId = Integer.parseInt(request.getParameter("tweet_id"));
        comment.setCreated(DateService.currentTimeToDb());
        HttpSession sess = request.getSession();
        User currentUser = (User)sess.getAttribute("currentUser");
        comment.setUser(currentUser);
        commentRepository.saveAndFlush(comment);
        return "redirect:/tweet/tweetDetails?tweet_id="+tweetId;
    }
}
