import java.util.*;

public class PlayingCard implements Comparable<PlayingCard>{
    private int rank;
    private Suit suit;

    public PlayingCard(Suit suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String toString(){
        return String.format("%d of %s", rank, suit);
    }

    public Suit getSuit(){
        return suit;
    }

    public int getRank(){
        return rank;
    }

    /**
     * compareTo automatically gets called by methods like Collections.sort().
     * Here, we can specify how we want our class to be sorted. When calling this method,
     * we want to rank the cards lowest to highest. So, the card "1 of CLUBS" will always be
     * first and "13 of SPADES" will always be last.
     * 
     * compareTo will call two other methods. First compareSuit, then compareRank if the suits are
     * the same. We want to organize cards from lowest to highest. If the left side playing card
     * (this object) is lower than the right side playing card, we will want to return -1. If it
     * is larger, we will want to return 1. If the cards are the same, we will return 0.
     * 
     * @param rightSidePlayingCard the PlayingCard object on the right side of the comparison
     * @return int -1, 0, or 1 depending on the playing card.
     */
    public int compareTo(PlayingCard rightSidePlayingCard){
        int comparedSuit = compareSuit(rightSidePlayingCard.getSuit());
        if(comparedSuit == 0){
            return compareRank(rightSidePlayingCard.getRank());
        }
        return comparedSuit;
    }

    /**
     * When comparing ranks, we are comparing ints. This means that we can use the normal
     * comparison operators of <, >, and ==.
     * 
     * @param rightSideRank the rank of the playing card on the right
     * @return int either a -1, 0, or 1
     */
    public int compareRank(int rightSideRank){
        // compare this.rank to rightSideRank

        if (this.rank < rightSideRank) {
            return -1;
        } else if (this.rank > rightSideRank) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Playing cards are typically sorted with CLUBS being the lowest, then DIAMONDS, HEARTS, and SPADES.
     * To do this, make some if statements that check this.suit and compare it to the righSideSuit.
     * 
     * @param rightSideSuit the suit of the playing card on the right side
     * @return int either a -1, 0, or 1
     */
    public int compareSuit(Suit rightSideSuit){
        // compare this.suit to rightSideSuit
        if (this.suit == Suit.CLUBS) {
            if (rightSideSuit == Suit.CLUBS) {
                return 0;
            } else {
                return -1;
            }
        } else if (this.suit == Suit.DIAMONDS) {
            if (rightSideSuit == Suit.CLUBS) {
                return 1;
            } else if (rightSideSuit == Suit.DIAMONDS) {
                return 0;
            } else {
                return -1;
            }
        } else if (this.suit == Suit.HEARTS) {
            if (rightSideSuit == Suit.SPADES) {
                return -1;
            } else if (rightSideSuit == Suit.HEARTS) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (rightSideSuit == Suit.SPADES) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    //Use this to test your code
    public static void main(String[] args) {
        ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
        PlayingCard p1 = new PlayingCard(Suit.CLUBS, 1);
        PlayingCard p2 = new PlayingCard(Suit.SPADES, 3);
        PlayingCard p3 = new PlayingCard(Suit.DIAMONDS, 7);
        deck.add(p1);
        deck.add(p2);
        deck.add(p3);
        System.out.println("UNSORTED: " + deck);
        Collections.sort(deck);
        System.out.println("SORTED: " + deck);
    }
}
