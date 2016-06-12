package barclays.hackathon.starks.model;

/**
 * Created by Bajrang on 6/11/2016.
 */
public enum Card {
	Arrival(0), Carnival(1), JetBlue(2), Apple(3);

	private Card(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	private int index;

	public static Card cardFrom(double classifyInstance) {
		Card[] values = Card.values();
		for (Card card : values) {
			if (card.getIndex() == classifyInstance)
				return card;
		}
		return null;
	}
}
