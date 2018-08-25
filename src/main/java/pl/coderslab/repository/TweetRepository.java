package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {

    List<Tweet> findAllByUser(User user);
    List<Tweet> findAllByUserId(Integer id);
}
