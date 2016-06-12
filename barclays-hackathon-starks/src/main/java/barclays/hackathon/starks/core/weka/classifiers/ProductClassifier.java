package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.core.weka.builders.InstanceBuilder;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import barclays.hackathon.starks.model.User;
import barclays.hackathon.starks.model.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weka.classifiers.bayes.NaiveBayesUpdateable;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class ProductClassifier implements Classifier {
	private ProductClassifierTrainer trainer;
	private NaiveBayesUpdateable naiveBayesUpdateable;

	@Autowired
	public ProductClassifier(ProductClassifierTrainer trainer, NaiveBayesUpdateable naiveBayesUpdateable) {
		this.trainer = trainer;
		this.naiveBayesUpdateable = naiveBayesUpdateable;
	}

	@Override
	public Recommendation classify(User user) throws Exception {
		NaiveBayesUpdateable trainedNaiveBayesAlgorithm = trainer.trainClassifierAlgorithm(naiveBayesUpdateable);
		double classifyInstance = trainedNaiveBayesAlgorithm
				.classifyInstance(InstanceBuilder.forNewUser(trainer.getDataSchema(), user));
		// map to offer
		return Recommendation.forNewCard(Card.cardFrom(classifyInstance).name());
	}
}
