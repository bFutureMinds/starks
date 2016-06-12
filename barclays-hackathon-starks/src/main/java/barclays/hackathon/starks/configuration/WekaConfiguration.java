package barclays.hackathon.starks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import barclays.hackathon.starks.core.weka.classifiers.OfferClassifierTrainer;
import barclays.hackathon.starks.core.weka.classifiers.ProductClassifierTrainer;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.converters.ArffLoader;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Configuration
public class WekaConfiguration {
	@Bean
	public NaiveBayesUpdateable naiveBayesUpdateable() {
		return new NaiveBayesUpdateable();
	}

	@Bean
	public OfferClassifierTrainer offerClassifierTrainer() {
		return new OfferClassifierTrainer(new ArffLoader());
	}

	@Bean
	public ProductClassifierTrainer productClassifierTrainer() {
		return new ProductClassifierTrainer(new ArffLoader());
	}

}
