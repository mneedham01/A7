import java.util.Collections;

/** Quicksort has method to quicksort cards and main method to run  */
public class Quicksort {

  /**
   * @params CardPile unsorted, SortRecorder record
   * @return sorted CardPile
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    if (unsorted.size() <= 1) {
      return unsorted;
    }

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();  // edit this!
    for (Card card : unsorted) {
      if (card.compareTo(pivot) < 0) {
        smaller.add(card);
      } else {
        bigger.add(card);
      }
    }
    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();

    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************
    CardPile sortedSmaller = sort(smaller, record);
    CardPile sortedBigger = sort(bigger, record);
    result.addAll(sortedSmaller);
    result.addLast(pivot);
    result.addAll(sortedBigger);


    // record the sorted result
    record.add(result);
    record.next();

    // return the sorted result here
    return result;
  }

  /** Runs sort method */
  public static void main(String[] args) {
    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    //Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // mix up the cards
    Collections.shuffle(cards);

    System.out.println("Unsorted: " + cards);

    // in your program, this would be a call to a real sorting algorithm
    cards = sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println("Sorted: " + cards);

    // make window appear showing the record
    //recorder.display("Card Sort Demo: QuickSort");
  }
}
