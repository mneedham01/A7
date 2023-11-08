import java.util.*;
/** SelectionSort has method to sort cards by selection and main method to run */
public class SelectionSort {
  /**
   * @params CardPile unsorted, SortRecorder record
   * @return sorted CardPile
   */
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

  /** Runs sort */
  public static void main(String[] args) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // mix up the cards
    Collections.shuffle(cards);

    // in your program, this would be a call to a real sorting algorithm
    cards = sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: SelectionSort");
  }
}
