package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.core.weka.builders.InstanceBuilder;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import barclays.hackathon.starks.model.User;
import barclays.hackathon.starks.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weka.classifiers.bayes.NaiveBayesUpdateable;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class OfferClassifier implements Classifier {
    private OfferClassifierTrainer trainer;
    private NaiveBayesUpdateable naiveBayesUpdateable;

    @Autowired
    public OfferClassifier(OfferClassifierTrainer trainer, NaiveBayesUpdateable naiveBayesUpdateable) {
        this.trainer = trainer;
        this.naiveBayesUpdateable = naiveBayesUpdateable;
    }

    @Override
    public Recommendation classify(User individual) throws Exception {
        NaiveBayesUpdateable trainedNaiveBayesAlgorithm = trainer.trainClassifierAlgorithm(naiveBayesUpdateable);
        double offer = trainedNaiveBayesAlgorithm
                .classifyInstance(InstanceBuilder.forExistingUser(trainer.getDataSchema(), individual));
        return Recommendation.forOffer(Offer.fromOffer(offer).name());
    }
}
