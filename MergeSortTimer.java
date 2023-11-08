import java.util.ArrayDeque;

/** MergeSort class has modified method to sort cards and main method to run */
public class MergeSortTimer {

  /**
   * @param CardPile list1, CardPile list2
   * @returns merged and ordered CardPile
   */
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


  /**
   * @param: CardPile unsorted
   * @returns: Sorted Cardpile
   */
  public static CardPile sort(CardPile unsorted) {

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
      }
    // return the sorted result here
    return queue.remove();
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
