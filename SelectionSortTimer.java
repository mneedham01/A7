import java.util.ListIterator;

public class SelectionSortTimer {

    public static CardPile sort(CardPile unsorted) {

        // Here is the result list you will be creating
        CardPile sorted = new CardPile();

        // until unsorted is empty
        while (! unsorted.isEmpty()) {
        // scan unsorted for smallest remaining element
        ListIterator<Card> position = unsorted.listIterator();
        Card smallest = position.next();
        while (position.hasNext()) {
            Card toCompare = position.next();
            if (toCompare.compareTo(smallest) < 0) {
            // then next card is smallest
            smallest = toCompare;
            }
        }
        // add to sorted list
        sorted.addLast(smallest);
        // remove smallest
        unsorted.remove(smallest);
        }
        // return the sorted result here
        return sorted;
    }
    /** Starts the program running */
    public static void main(String args[]) {
        if (args.length<1) {
            System.err.println("Please specify how many cards to sort!");
        } else {
            Card[] deck = Card.newDeck(true);
            CardPile cards = new CardPile();
            for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
                cards.add(deck[(int)(52*Math.random())]);
            }
            sort(cards);
        }
    }
}
