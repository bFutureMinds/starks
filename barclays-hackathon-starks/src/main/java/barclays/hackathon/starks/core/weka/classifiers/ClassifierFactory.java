package barclays.hackathon.starks.core.weka.classifiers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class ClassifierFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Classifier getClassifier(boolean isExistingCustomer) {
        if (isExistingCustomer) {
            return applicationContext.getBean(OfferClassifier.class);
        }
        return applicationContext.getBean(ProductClassifier.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
