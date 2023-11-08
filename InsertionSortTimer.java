public class InsertionSortTimer {

    /**  */
  public static CardPile sort(CardPile unsorted) {

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();

    // add first element to sorted
    sorted.add(unsorted.removeFirst());
    while (! unsorted.isEmpty()) {
      Card toSort = unsorted.removeFirst();
      sorted.add(findPosition(toSort, sorted), toSort);
    }
  return sorted;
  }

  /**  */
  public static int findPosition (Card toSort, CardPile sorted) {
    int position = 0;
    while (position < sorted.size() && sorted.get(position).compareTo(toSort) <= 0) {
      position ++;
    }
    return position;
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
