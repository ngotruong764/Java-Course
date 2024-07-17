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

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled deck", 4);

        Collections.reverse(deck);

        Card.printDeck(deck,"Reversed Deck of card", 4 );

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed: ", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("Sublist index for tens"+subListIndex);
        System.out.println("Contains = "+ deck.containsAll(tens));

        boolean disjoint = Collections.disjoint(deck, kings);
        System.out.println("Disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(tens, kings);
        System.out.println("Disjoint = " + disjoint2);

        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = " + foundIndex);
        System.out.println(deck.get(foundIndex));

        int foundIndex2 = deck.indexOf(tenOfHearts);

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32,36), "Ten row", 1);

        int clubFrequency = Collections.frequency(deck, tenOfClubs);
        System.out.println("Ten of Clubs Cards = "+ clubFrequency);

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied, 2);

        System.out.println("UnRotated: "+ deck.subList(0,13));
        System.out.println("Rotated: "+ copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for (int i = 0; i < copied.size(); i++){
            Collections.swap(copied, i, copied.size()-1);
        }
        System.out.println(copied);
    }
}
