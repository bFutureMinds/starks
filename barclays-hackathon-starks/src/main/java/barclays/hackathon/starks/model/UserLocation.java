package barclays.hackathon.starks.model;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public enum UserLocation {
    METRO(0),
    NON_METRO(1);

    private static Map<String, String> cities = Maps.newHashMap();
	private int index;

    static {
        cities.put("kolkata", null);
        cities.put("mumbai", null);
        cities.put("delhi", null);
        cities.put("hyderabad", null);
        cities.put("bangalore", null);
    }

    public static UserLocation fromCity(String city) {
        if (cities.containsKey(city.toLowerCase())) {
            return METRO;
        }
        return NON_METRO;
    }

    private UserLocation(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
}
