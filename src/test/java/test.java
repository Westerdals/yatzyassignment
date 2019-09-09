import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class test {

    @Test
    public void shouldScoreOnes() {
        assertEquals(4, score("ONES", new int[] { 2, 1, 1, 1, 1} ));
        assertEquals(2, score("ONES", new int[] { 2, 1, 2, 2, 1 }));
    }

    @Test
    void shouldScoreTwos() {
        assertEquals(0, score("TWOS", new int[] { 1, 3, 4, 5, 6 }));
        assertEquals(6, score("TWOS", new int[] { 2, 1, 2, 2, 1 }));
    }

    @Test
    void shouldScoreThrees() {
        assertEquals(3, score("THREES", new int[] { 3, 4, 1, 5, 2 }));
        assertEquals(9, score("THREES", new int[] { 3, 1, 2, 3, 3 }));
    }

    @Test
    void shouldScoreFours() {
        assertEquals(12, score("FOURS", new int[] { 4, 1, 3, 4, 4 }));
        assertEquals(4, score("FOURS", new int[] { 5, 2, 4, 1, 3 }));
    }

    @Test
    void shouldScoreFives() {
        assertEquals(10, score("FIVES", new int[] { 5, 1, 3, 5, 4 }));
        assertEquals(5, score("FIVES", new int[] { 5, 2, 4, 1, 3 }));
    }

    @Test
    void shouldScoreSixes() {
        assertEquals(12, score("SIXES", new int[] { 6, 1, 3, 6, 4 }));
        assertEquals(6, score("SIXES", new int[] { 6, 2, 4, 1, 3 }));
    }

    public int score(String categoryName, int[] dice) {

        int[] frequencies = new int[7];
        for (int die : dice) {
            frequencies[die]++;
        }
        if (categoryName == "ONES") {
            // hidden array with frequencies of whatever occurs more than once
            singleDiceScore(1, frequencies);
            }

        if (categoryName == "TWOS") {
            // new loop checking for TWOS
            singleDiceScore(2, frequencies);
            }

        if (categoryName == "THREES") {
            // new loop checking for THREES
            singleDiceScore(3, frequencies);
        }

        return 0;
        }

        private int singleDiceScore(int diceValue, int[] frequencies) {
            for (int i = 1; i < frequencies.length; i++) {
                return frequencies[diceValue] * diceValue;
            }
    }

    }




/*
 1.) specify if for every category
 2.) implement new methods for different category, like something for pairs, one for straight etc

 3.) Record and write tests on example ONES and TWOS
 4.) push it to Git

*/

