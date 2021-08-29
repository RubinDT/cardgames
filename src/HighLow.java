
public class HighLow {
    /**
     * this program lets the user play HighLow, a simple
     * card game.  User guesses whether the next card
     * will be higher or lower than the previous card.
     * Good luck!
     */

    public static void main(String[] args) {
        System.out.println("\nReady to play HighLow?");
        System.out.println("All you need to do is guess if the ");
        System.out.println("next card will be higher or lower ");
        System.out.println("than the card shown. See how many correct ");
        System.out.println("guesses in a row you can get! Aces are \"one\"");
        System.out.println("It is simple. You'll love it.\n");

        Integer gamesPlayed = 0;
        Integer sumOfScores = 0;

        Double averageScore = 0.0;
        if (gamesPlayed != 0 && sumOfScores != 0) {
            averageScore = ((double) sumOfScores) / ((double) gamesPlayed);
        }

        boolean playAgain;

        do {
            int scoreThisGame;
            scoreThisGame = play();
            sumOfScores += scoreThisGame;
            gamesPlayed++;
            TextIO.put("Play again?");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);

        System.out.println();
        if (gamesPlayed != 0 && sumOfScores != 0) {
            averageScore = ((double) sumOfScores) / ((double) gamesPlayed);
        }
        System.out.println("You played " + gamesPlayed + " games.");
        System.out.printf("Your averages score was %1.2f.\n", (double) averageScore);
    }


    public static Integer play() {
        //lets the user play this fun game
        Deck deck = new Deck();
        deck.shuffle();
        Card card = deck.dealCard(); //start with the first card in the deck
        Card nextCard;
        boolean rightAnswer = false;
        Integer score = 0;
        char guess = 'a';


        //show player a card, have them guess if the next one is higher
        //or lower


        do {
            System.out.println("Here's the card: " + card.toString());
            System.out.println("Do you think the next card will be higher (H) " +
                    "or lower (L)?");
            guess = TextIO.getChar(); //get user response

            nextCard = deck.dealCard(); //generate a new card


            while (guess != 'h' && guess != 'H' && guess != 'l' && guess != 'L') {
                System.out.println("Invalid entry - try \'H\' or \'L\'");
                guess = TextIO.getChar();
            }

            if (nextCard.getFaceValue() == card.getFaceValue()) {
                System.out.println("They were equal...no points awarded...");
                System.out.println("The card was " + nextCard.toString());
                card = nextCard;
                rightAnswer = true;
            } else if (nextCard.getFaceValue() > card.getFaceValue()) {
                if (guess == 'h' || guess == 'H') {
                    System.out.println("Correct! The next card is " + nextCard.toString());
                    rightAnswer = true;
                    card = nextCard;
                    score++;
                } else {
                    rightAnswer = false;
                    break;
                }

            } else if (nextCard.getFaceValue() < card.getFaceValue()) {
                if (guess == 'l' || guess == 'L') {
                    System.out.println("Correct! The next card is " + nextCard.toString());
                    rightAnswer = true;
                    card = nextCard;
                    score++;
                } else {
                    rightAnswer = false;
                    break;
                }

            }
        } while (rightAnswer);

        System.out.println("Nope! You're wrong.");
        System.out.println("The next card was " + nextCard.toString());
        System.out.println("Game Over.  Score for this game: " + score);
        System.out.println();

        return score;
    }

}