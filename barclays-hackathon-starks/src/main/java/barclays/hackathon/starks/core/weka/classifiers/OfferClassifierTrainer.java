package barclays.hackathon.starks.core.weka.classifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created by Bajrang on 6/11/2016.
 */
public class OfferClassifierTrainer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OfferClassifierTrainer.class);

    private ArffLoader arffLoader;
    private Instances instances;

    public OfferClassifierTrainer(ArffLoader arffLoader) {
        this.arffLoader = arffLoader;
    }

    @PostConstruct
    private void init() {
        try {
            arffLoader.setFile(new ClassPathResource("existing-users.txt").getFile());
            instances = arffLoader.getStructure();
            instances.setClassIndex(instances.numAttributes() - 1);
        } catch (IOException e) {
            LOGGER.error("Failed to Load instances", e);
        }
    }

    public NaiveBayesUpdateable trainClassifierAlgorithm(NaiveBayesUpdateable classificationAlgorithm) {
        try {
            classificationAlgorithm.buildClassifier(instances);
            updateClassifier(classificationAlgorithm);
        } catch (Exception e) {
            LOGGER.error("Failed to classify instances", e);
        }
        return classificationAlgorithm;
    }

    private void updateClassifier(NaiveBayesUpdateable classificationAlgorithm) throws Exception {
        Instance current;
        while ((current = arffLoader.getNextInstance(instances)) != null) {
            classificationAlgorithm.updateClassifier(current);
        }
    }

    public Instances getDataSchema() throws IOException {
        return instances.stringFreeStructure();
    }
}
