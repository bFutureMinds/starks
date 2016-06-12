package barclays.hackathon.starks.model;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public enum AgeGroup {
    UNKNOWN(null, null),
    AGE_RANGE_17_25(17, 25),
    AGE_RANGE_25_35(25, 35),
    AGE_RANGE_35_PLUS(21, null);

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    private Integer min;
    private Integer max;

    AgeGroup(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }
//
//    public static AgeGroup fromMinMax(Integer min, Integer max) {
//        if (min == 17 && max == 25) {
//            return AGE_RANGE_17_25;
//        } else if (min == 25 && max == 35) {
//            return AGE_RANGE_25_35;
//        } else if (min == 35 && max == null) {
//            return AGE_RANGE_35_PLUS;
//        }
//
//        AgeGroup unknown = AgeGroup.UNKNOWN;
//        unknown.min = min;
//        unknown.max = max;
//        return unknown;
//    }
}
