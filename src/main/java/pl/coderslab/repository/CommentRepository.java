package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByTweetOrderByCreated(Tweet tweet);
    List<Comment> findAllByTweetIdOrderByCreatedDesc(Integer id);

}
