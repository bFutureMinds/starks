package barclays.hackathon.starks.model;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public enum LifeMoment {
    MARRIAGE(0), BIRTHDAY(1);

    private int index;

    private LifeMoment(int index) {
        this.index = index;

    }

    public int getIndex() {
        return index;
    }
}
