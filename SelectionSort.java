import java.util.*;

public class SelectionSort {

  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    // register the starting configuration with the recorder
    record.add(unsorted);

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
      // record
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }

    // return the sorted result here
    return sorted;
  }

  public static void main(String[] args) {
    // initialize deck of cards
    CardPile unsorted = new CardPile(Card.newDeck(true), 2, 2);
    // shuffle it
    Collections.shuffle(unsorted);
    // create a new record
    SortRecorder record = new SortRecorder();
    // sort it
    CardPile sorted = sort(unsorted, record);
  }
}
