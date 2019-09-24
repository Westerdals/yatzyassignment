import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    @Test
    void shouldWork() {
        assertEquals(3,3);
    }

    @Test
    public void shouldScoreOnes() {
        assertEquals(4, score("ONES", new int[] { 2, 1, 1, 1, 1 }));
        assertEquals(2, score("ONES", new int[] { 2, 1, 2, 2, 1 }));
    }

    @Test
    public void shouldScoreTwos() {
        assertEquals(0, score("TWOS", new int[] { 1, 3, 4, 5, 6 }));
        assertEquals(6, score("TWOS", new int[] { 2, 1, 2, 2, 1 }));
    }

    @Test
    public void shouldScoreThrees() {
        assertEquals(3, score("THREES", new int[] { 3, 4, 1, 5, 2 }));
        assertEquals(9, score("THREES", new int[] { 3, 1, 2, 3, 3 }));
    }

    @Test
    public void shouldScoreFours() {
        assertEquals(12, score("FOURS", new int[] { 4, 1, 3, 4, 4 }));
        assertEquals(4, score("FOURS", new int[] { 5, 2, 4, 1, 3 }));
    }

    @Test
    public void shouldScoreFives() {
        assertEquals(10, score("FIVES", new int[] { 5, 1, 3, 5, 4 }));
        assertEquals(5, score("FIVES", new int[] { 5, 2, 4, 1, 3 }));
    }

    @Test
    public void shouldScoreSixes() {
        assertEquals(12, score("SIXES", new int[] { 6, 1, 3, 6, 4 }));
        assertEquals(6, score("SIXES", new int[] { 6, 2, 4, 1, 3 }));
    }

    @Test
    public void shouldScorePairs() {
        assertEquals(8, score("PAIRS", new int[] { 4, 6, 4, 2, 1}));
        assertEquals(12, score("PAIRS", new int[] { 6, 2, 1, 6, 3 }));
    }

    @Test
    public void shouldScoreDoublePairs() {
        assertEquals(14, score("DOUBLEPAIRS", new int[] { 2, 3, 2, 5, 5 }));
        assertEquals(10, score("DOUBLEPAIRS", new int[] { 1, 4, 1, 6, 4 }));
    }

    public int score(String categoryName, int[] dice) {

        int[] frequencies = new int[7];
        for (int die : dice) {
            frequencies[die]++;
        }
        if (categoryName == "ONES") {
            // hidden array with frequencies of whatever occurs more than once
            return singleDiceScore(1, frequencies);
            }

        if (categoryName == "TWOS") {
            return singleDiceScore(2, frequencies);
            }

        if (categoryName == "THREES") {
            return singleDiceScore(3, frequencies);
        }

        if (categoryName == "FOURS") {
            return singleDiceScore(4, frequencies);
        }

        if (categoryName == "FIVES") {
            return singleDiceScore(5, frequencies);
        }

        if (categoryName == "SIXES") {
            return singleDiceScore(6, frequencies);
        }

        if (categoryName == "PAIRS") {
            return onePairDiceScore(frequencies);
        }
        return 0;
        }

        public int onePairDiceScore(int[] frequencies) {
            for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] == 2) {
                return i * 2;
            }
        }
            return 0;
        }

        public int singleDiceScore(int diceValue, int[] frequencies) {
            for (int i = 1; i < frequencies.length; i++) {
                return frequencies[diceValue] * diceValue;
            }

            return 0;
        }
    }




/*
 1.) specify if for every category
 2.) implement new methods for different category, like something for pairs, one for straight etc

 3.) Record and write tests on example ONES and TWOS
 4.) push it to Git

 Nested loops?

 Lower Section:

One Pair: Two dice showing the same number. Score: Sum of those two dice.
En løsning:
Du lar funksjonen enten returnere false, eller et par / et svar.
Og så tar den i mot previous høyeste tall  / svar som parameter. default / første input argument blir jo da 0.
Dersom funksjonen finn noe høyere enn input, returnere du. Loop der I en while. Når funksjonen returnere false brytes loopen, og du har fått en variabel som inneholde høyest mulig score fra par i settet.
Evt så sortere du bare arrayet
Og så finn du par i det sorterte arrayet
Første par vil jo da utvilsomt være størst





Two Pairs: Two different pairs of dice. Score: Sum of dice in those two pairs.
Three of a Kind: Three dice showing the same number. Score: Sum of those three dice.
Four of a Kind: Four dice with the same number. Score: Sum of those four dice.
Small Straight: The combination 1-2-3-4-5. Score: 15 points (sum of all the dice).
Large Straight: The combination 2-3-4-5-6. Score: 20 points (sum of all the dice).
Full House: Any set of three combined with a different pair. Score: Sum of all the dice.
Chance: Any combination of dice. Score: Sum of all the dice.
Yatzy: All five dice with the same number. Score: 50 points.
Two Pairs and Full House must have different numbers so that the combination 15566 will score 22 as Two Pairs, but 15555 will score nothing in that category.

Some combinations offer the player a choice as to which category to score them under.
A full house could be scored in the Full House, the Three-Of-A-Kind, Two Pairs, One Pair or the Chance categories.
So 22555 would score 19 in Full House or Chance, 15 in Three-Of-A-Kind, 14 in Two Pairs or 10 in One Pair.

*/

