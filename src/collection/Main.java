package collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);

        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("card.size() = "+ cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        System.out.println(acesOfHearts);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        System.out.println(kingsOfClubs);

        Collections.addAll(cards, cardArray);
        System.out.println(cards);
    }
}
