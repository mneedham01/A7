import java.util.ArrayDeque;
import java.util.Collections;

/** */
public class MergeSort {

  /** */
  public static CardPile merge(CardPile list1, CardPile list2) {
    CardPile merged = new CardPile();
    // while both lists are not empty
    while (! list1.isEmpty() && ! list2.isEmpty()) {
      // look at the first element in each list
      Card head1 = list1.getFirst();
      Card head2 = list2.getFirst();
      // if negative, then head1 is smaller
      // if positive, then head2 is smaller
      Card smaller = head1.compareTo(head2) < 0 ? list1.removeFirst() : list2.removeFirst();
      // take the smaller of the two, add it to merged list
      merged.addLast(smaller);
    }
    // determine which list is empty, add the rest of the other to the end of merged
    if (list1.isEmpty()) {
      merged.addAll(list2);
    } else {
      merged.addAll(list1);
    }
    return merged;
  }

  /**  */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    // register the starting configuration with the recorder
    record.add(unsorted);

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
    // put each element into own singleton CardPiles
    for (Card card : unsorted) {
      Card[] array = {card};
      CardPile single = new CardPile(array, 2 ,2);
      // add all the piles to a queue
      queue.add(single);
    }
    // while more than one list remains on the queue
    while (queue.size() > 1) {
      // remove the first two lists, merge
      CardPile list1 = queue.removeFirst();
      CardPile list2 = queue.removeFirst();
      CardPile merged = merge(list1, list2);
      // put result at the end of the queue
      queue.add(merged);
      record.next();        // tell it this is a new step
      for (CardPile pile: queue) { // add all piles
        record.add(pile);
      }
    }
    // return the sorted result here
    return queue.remove();
  }

  /**  */
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

    // make window appear showing the record
    recorder.display("Card Sort Demo: MergeSort");
  }
}
