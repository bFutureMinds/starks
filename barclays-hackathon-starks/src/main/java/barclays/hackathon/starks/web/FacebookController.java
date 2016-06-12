package barclays.hackathon.starks.web;

import barclays.hackathon.starks.core.weka.engine.RecommendationEngine;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */

@Controller
@RequestMapping("/fb")
public class FacebookController {

    private Facebook facebook;
    private ConnectionRepository repository;

    @Autowired
    public FacebookController(Facebook facebook, ConnectionRepository repository) {
        this.facebook = facebook;
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloFacebook(Model model) throws JsonProcessingException {
        if (repository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        User userProfile = facebook.userOperations().getUserProfile();
        System.out.println(new ObjectMapper().writeValueAsString(userProfile));
        PagedList<User> friendProfiles = facebook.friendOperations().getFriendProfiles();
        for (User friendProfile : friendProfiles) {
            System.out.println(friendProfile.getName() + " ");
            System.out.println(friendProfile.getEmail() + " ");
            System.out.println(friendProfile.getAgeRange() + " ");
            System.out.println(friendProfile.getAbout() + " ");
            System.out.println(friendProfile + " ");
            System.out.println("==========================");
        }
        model.addAttribute("feed", feed);
        return "hello";
    }
}