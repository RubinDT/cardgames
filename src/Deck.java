
public class Deck {
    //no jokers in this deck
    Card[] deck = new Card[52]; //standard deck
    Integer index = 0;

    public Deck() {
        //create an unshuffled deck
        //initialize standard cards
        int tempDeckCounter = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= 13; j++) {
                this.deck[tempDeckCounter] = new Card(i, j);
                tempDeckCounter++;
            }
        }


    }

    public void shuffle() {
        //shuffle this deck
        Card temp = new Card();
        int tempIndex;

        //scan through the array placing each card in a random location
        //the i'th card will swap places with another card in the random'th position

        for (int i = 0; i < this.deck.length; i++) {
            tempIndex = (int) (Math.random() * this.deck.length);//randomized index
            temp = this.deck[i];//temporarily hold the deck in the ith position
            this.deck[i] = this.deck[tempIndex];//and swap with the card in the tempIndex position
            this.deck[tempIndex] = temp;
        }

        this.index = 0; //reset index after a shuffle, we start at the 'top' of the deck
    }

    public Card dealCard() {
        //get the next card from this deck
        this.index++;
        return this.deck[this.index - 1];
    }

    public Integer cardsLeft() {
        //cards left in the deck to be dealt
        Integer temp = deck.length - this.index;
        if (this.index < 0) {
            throw new IllegalStateException();
        }
        return temp;

    }


}

