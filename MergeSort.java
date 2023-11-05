import java.util.ArrayDeque;
import java.util.Collections;

public class MergeSort {

  public static CardPile merge(CardPile list1, CardPile list2) {
    CardPile merged = new CardPile();
    // while both lists are not empty
    while (! list1.isEmpty() || ! list2.isEmpty()) {
      // look at the first element in each list
      Card head1 = list1.getFirst();
      Card head2 = list2.getFirst();
      // if positive, then head1 is smaller
      // if smaller is negative, then head2 is smaller
      Card smaller = head1.compareTo(head2) > 0 ? head1 : head2;
      // take the smaller of the two, add it to merged list
      merged.addLast(smaller);
    }
    return merged;
  }

  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    // register the starting configuration with the recorder
    record.add(unsorted);

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
    // put each element into own singleton CardPiles
    for (Card element : unsorted) {
      Card[] array = {element}
      CardPile single = new CardPile(array, 2 ,2);
      // add all the piles to a queue
      queue.add(single);
    }
    // while more than one list remains on the queue
    while (! queue.isEmpty()) {
      // remove the first two lists, merge
      CardPile list1 = queue.pop();
      CardPile list2 = queue.pop();
      // put result at the end of the queue
      queue.addLast(merge(list1, list2));
      record.next();        // tell it this is a new step
      for (CardPile pile: queue) { // add all piles
        record.add(pile);
      }
    }

  //     ## MergeSort
  // - Begin by placing each element of `unsorted` into its own new singleton `CardPile` and add all those piles to a queue.
  // - While more than one list remains on the queue:
  //   - Remove the first two lists from the queue and merge them, preserving their sorted order.
  //   - Put the result back at the end of the queue.


  // _To merge two sorted lists into a single sorted list:_
  //   - Look at the first element in each list.
  //   - Take the smaller of the two off the front of its old list and put it at the end of a new (merged) list.
  //   - Repeat this until both one of the old lists is empty, at which point you can append the remainder of the other original list to the new list.
  //   - If the original lists were sorted, and you always take the smallest element available, then the resulting list will also be sorted.


    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************

    // return the sorted result here
    return queue.remove();
  }

   public static void main(String[] args) {
    // initialize deck of cards
    CardPile unsorted = new CardPile(Card.newDeck(true), 2, 2);
    System.out.println("unsorted: "+ unsorted);
    // shuffle it
    Collections.shuffle(unsorted);
    // create a new record
    SortRecorder record = new SortRecorder();
    // sort it
    CardPile sorted = sort(unsorted, record);
    System.out.println("sorted: "+ sorted);
  }
}
