package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;

public class TweetConverter implements Converter<String, Tweet> {

    @Autowired
    private TweetRepository tweetRepository;
    public Tweet convert(String s) {
        return tweetRepository.findOne(Integer.parseInt(s));
    }
}
