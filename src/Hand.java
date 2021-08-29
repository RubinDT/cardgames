import java.util.Arrays;
import java.util.Comparator;

public class Hand {

    Card[] ownedCards;

    public Hand() {
    }

    public void clear() {
        //empty hand
        this.ownedCards = new Card[0];
    }

    public void addCard(Card c) {
        //add a card to this hand
        this.ownedCards = Arrays.copyOf(this.ownedCards, this.ownedCards.length + 1);
        this.ownedCards[this.ownedCards.length] = c;

    }


    public void removeCard(Card c) {
        //re-make with a Map hand?
        int index = -1;
        //for loop through the array; comare c.getsuit and c.getvalue to this.ownedcards[i].gets...
        for (int i = 0; i < this.ownedCards.length; i++) {
            if (c.getFaceValue() == this.ownedCards[i].getFaceValue() && c.getSuit() == this.ownedCards[i].getSuit()) {
                index = i;
            }
        }

        Card[] tempHand = new Card[this.ownedCards.length - 1];

        for (int i = 0; i < this.ownedCards.length; i++) {
            int tempHandIndex = 0;
            if (i != index) {
                tempHand[tempHandIndex] = this.ownedCards[i];
                //copy existing ownedCards to tempHand EXCEPT for the card to be removed
            }

        }
        this.ownedCards = tempHand;
    }

    public void removeCard(int position) {
        //re-make with a Map hand?

        //for loop to create new hand
        Card[] tempHand = new Card[this.ownedCards.length - 1];

        for (int i = 0; i < this.ownedCards.length; i++) {
            int tempHandIndex = 0;
            if (i != position) {
                tempHand[tempHandIndex] = this.ownedCards[i];
                //copy existing ownedCards to tempHand EXCEPT for the card to be removed
            }

        }
        this.ownedCards = tempHand;
    }

    public int getCardCount() {
        return this.ownedCards.length;
    }

    public Card getCard(int position) {
        //throw IllegalArgument if the specified position does not exist in the hand

        return this.ownedCards[position];
    }

    public void sortBySuit() {
        Arrays.sort(this.ownedCards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                //return >1 if c1 is 'greater' than c2
                //return <1 if c1 is 'less' than c2
                //return 0 if they are 'equal'

                if (c1.getSuit() > c2.getSuit()) {
                    return 1;
                }

                if (c1.getSuit() < c2.getSuit()) {
                    return -1;
                }
                    return 0;

            }
        });
    }

    public void sortByValue() {
        Arrays.sort(this.ownedCards, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                //return >0 if c1 is 'greater' than c2
                //return <0 if c1 is 'less' than c2
                //return 0 if c1 == c2
                if (c1.getFaceValue() > c2.getFaceValue()) {
                    return 1;
                }
                if (c1.getFaceValue() < c2.getFaceValue()) {
                    return -1;
                }
                return 0;
            }
        });
    }

}
