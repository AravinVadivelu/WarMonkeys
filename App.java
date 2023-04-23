import java.util.ArrayList;
import java.util.Collections;
public class App {
    public static void main(String[] args) throws Exception {
       Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Deal cards to players
        while (!deck.isEmpty()) {
            player1.takeCard(deck.dealCard());
            player2.takeCard(deck.dealCard());
        }

        // Play the game
        while (!player1.isOutOfCards() && !player2.isOutOfCards()) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            if (card1.getRank().compareTo(card2.getRank()) >0) {
                System.out.println(player1.getName() + " wins the round!");
                player1.collectCards(card1, card2);
            } else if (card1.getRank().compareTo(card2.getRank()) <0 ) {
                System.out.println(player2.getName() + " wins the round!");
                player2.collectCards(card1, card2);
            } else {
                System.out.println("War!");
                ArrayList<Card> warCards = new ArrayList<Card>();
                warCards.add(card1);
                warCards.add(card2);
                warCards.addAll(player1.playCards(3));
                warCards.addAll(player2.playCards(3));
                Collections.shuffle(warCards);

                Card warCard1 = warCards.remove(0);
                Card warCard2 = warCards.remove(0);

                System.out.println(player1.getName() + " plays " + warCard1);
                System.out.println(player2.getName() + " plays " + warCard2);

                if (warCard1.getRank().compareTo(warCard2.getRank()) > 0 ) {
                    System.out.println(player1.getName() + " wins the war!");
                    player1.collectCards(card1, card2, warCard1, warCard2, warCards);
                } else if (warCard1.getRank().compareTo(warCard2.getRank()) < 0) {
                    System.out.println(player2.getName() + " wins the war!");
                    player2.collectCards(card1, card2, warCard1, warCard2, warCards);
                } else {
                    System.out.println("Another war!");
                    warCards.add(card1);
                    warCards.add(card2);
                    warCards.add(warCard1);
                    warCards.add(warCard2);
                    playWar(player1, player2, warCards);
                }
            }
            System.out.println(player1.getName() + " has " + player1.getNumCards() + " cards.");
            System.out.println(player2.getName() + " has " + player2.getNumCards() + " cards.");
            System.out.println();
        }

        // Determine the winner
        if (player1.isOutOfCards()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println(player1.getName() + " wins the game!");
        }
    }

    private static void playWar(Player player1, Player player2, ArrayList<Card> warCards) {
        if (player1.isOutOfCards() || player2.isOutOfCards()) {
            return;
        }

        warCards.addAll(player1.playCards(3));
        warCards.addAll(player2.playCards(3));
        Collections.shuffle(warCards);

        Card warCard1 = warCards.remove
    }
}
