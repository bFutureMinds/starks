package barclays.hackathon.starks.model;


import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private UserLocation location;
    private LocalDate dob;
    private String interestedIn;
    private LifeMoment lifemoment;
    private AgeRange ageRange;
    private Card card;
	private boolean isExistingCustomer;

    public User(String id,
                String name,
                String email,
                UserLocation location,
                LocalDate dob,
                String interestedIn,
                LifeMoment lifemoment,
                AgeRange ageRange,
                Card card) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
        this.dob = dob;
        this.interestedIn = interestedIn;
        this.lifemoment = lifemoment;
        this.ageRange = ageRange;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserLocation getLocation() {
        return location;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public LifeMoment getLifemoment() {
        return lifemoment;
    }

    public void setLifemoment(LifeMoment lifemoment) {
        this.lifemoment = lifemoment;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public Card getCard() {
        return card;
    }	

	public boolean isExistingCustomer() {
		return isExistingCustomer;
	}

	public void setExistingCustomer(boolean isExistingCustomer) {
		this.isExistingCustomer = isExistingCustomer;
	}
}
