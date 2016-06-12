package barclays.hackathon.starks.web.vo;

/**
 * Created by Bajrang on 6/12/2016.
 */
public class UserOffer {
    private String userName;
    private String offer;
    private String moment;

    @SuppressWarnings("unused")

    private UserOffer() {

    }

    private UserOffer(String userName, String offer, String moment) {
        this.userName = userName;
        this.offer = offer;
        this.moment = moment;
    }

    public static UserOffer from(String userName, String recommendation, String moment) {
        return new UserOffer(userName, recommendation, moment);
    }

    public String getUserName() {
        return userName;
    }

    public String getOffer() {
        return offer;
    }

    public String getMoment() {
        return moment;
    }
}
