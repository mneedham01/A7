import java.util.Collections;

/**  */
public class InsertionSort {

  /**  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();

    // add first element to sorted
    sorted.add(unsorted.removeFirst());
    while (! unsorted.isEmpty()) {
      Card toSort = unsorted.removeFirst();
      sorted.insertAfter(toSort, findAfter(toSort, sorted));
      // record
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }
  return sorted;
  }

  /**  */
  public static Card findAfter (Card toSort, CardPile sorted) {
    int position = 0;
    while (position < sorted.size() && sorted.get(position).compareTo(toSort) <= 0) {
      position ++;
    }
    return sorted.get(position);
  }

  /**  */
  public static void main(String[] args) {
    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    // Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // mix up the cards
    Collections.shuffle(cards);
    System.out.println("unsorted = " + cards);

    // in your program, this would be a call to a real sorting algorithm
    cards = sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println("sorted = " + cards);

    // make window appear showing the record
    //recorder.display("Card Sort Demo: InsertionSort");
  }
}
