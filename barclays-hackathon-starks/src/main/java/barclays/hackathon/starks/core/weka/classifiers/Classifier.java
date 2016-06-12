package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.model.User;
import barclays.hackathon.starks.core.weka.vo.Recommendation;

/**
 * Created by Bajrang on 6/11/2016.
 */
public interface Classifier {
    Recommendation classify(User individual) throws Exception;
}
