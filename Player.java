import java.util.ArrayList;
import java.util.Collections;
public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    public Card playCard() {
        return this.hand.remove(0);
    }

    public ArrayList<Card> playCards(int numCards) {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < numCards && !this.hand.isEmpty(); i++) {
            cards.add(this.playCard());
        }
        return cards;
    }

    public void collectCards(Card... cards) {
        Collections.addAll(this.hand, cards);
    }

    public int getNumCards() {
        return this.hand.size();
    }

    public boolean isOutOfCards() {
        return this.hand.isEmpty();
    }
}
