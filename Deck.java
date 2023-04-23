import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card dealCard() {
        return this.cards.remove(0);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }
}
