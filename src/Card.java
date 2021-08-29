public class Card {

    private final Integer suit;
    private final Integer faceValue;

    //how to use an enum type ..?
    // /enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS, JOKER} //189
public Card(){
    suit = this.JOKER;
    faceValue = 1;
}

    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;


    public Card(int suit, int faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Integer getFaceValue() {
        return this.faceValue;
    }

    public Integer getSuit(){
        return this.suit;
    }

    public String getSuiteAsString(){
        switch(this.suit){
            case 0: return "Spades";
            case 1: return "Hearts";
            case 2: return "Diamonds";
            case 3: return "Clubs";
            case 4: return "Joker";
        }

        return "error - not a valid suit";
    }

    public String getFaceValueAsString(){
        switch(this.faceValue){
            case 1: return "Ace";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
        }

        return this.faceValue.toString();
    }

    public String toString(){
        return this.getFaceValueAsString() + " of " + this.getSuiteAsString();

    }
}

