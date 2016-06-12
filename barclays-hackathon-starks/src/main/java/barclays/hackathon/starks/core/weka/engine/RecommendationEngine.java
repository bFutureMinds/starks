package barclays.hackathon.starks.core.weka.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import barclays.hackathon.starks.core.weka.classifiers.Classifier;
import barclays.hackathon.starks.core.weka.classifiers.ClassifierFactory;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import barclays.hackathon.starks.model.User;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class RecommendationEngine {
    private ClassifierFactory classifierFactory;

    @Autowired
    public RecommendationEngine(ClassifierFactory classifierFactory) {
        this.classifierFactory = classifierFactory;
    }

    public Recommendation recommendation(User user) throws Exception {
        Classifier classifier = classifierFactory.getClassifier(isExistingUser(user));
        return classifier.classify(user);
    }

    private boolean isExistingUser(User user) {
        return user.getCard() != null;
    }
}
