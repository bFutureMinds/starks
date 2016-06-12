package barclays.hackathon.starks.core.weka.vo;

import static barclays.hackathon.starks.core.weka.vo.Recommendation.RecommendationType.NEW_CARD;
import static barclays.hackathon.starks.core.weka.vo.Recommendation.RecommendationType.OFFER;

/**
 * Created by Bajrang on 6/11/2016.
 */
public class Recommendation {
    private RecommendationType type;
    private String recommendation;

    private Recommendation(RecommendationType type, String recommendation) {
        this.recommendation = recommendation;
        this.type = type;
    }

    public static Recommendation forNewCard(String recommendation) {
        return new Recommendation(NEW_CARD, recommendation);
    }

    public static Recommendation forOffer(String recommendation) {
        return new Recommendation(OFFER, recommendation);
    }

    public enum RecommendationType {
        NEW_CARD,
        OFFER
    }

    public RecommendationType getType() {
        return type;
    }

    public String getRecommendation() {
        return recommendation;
    }
}
