package no.forelesning.yatzyJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    void shouldWork() {
        assertEquals(3, 3);
    }

    @Test
    public void shouldScoreOnes() {
        assertEquals(4, score("ONES", new int[]{2, 1, 1, 1, 1}));
        assertEquals(2, score("ONES", new int[]{2, 1, 2, 2, 1}));
    }

    @Test
    public void shouldScoreTwos() {
        assertEquals(0, score("TWOS", new int[]{1, 3, 4, 5, 6}));
        assertEquals(6, score("TWOS", new int[]{2, 1, 2, 2, 1}));
    }

    @Test
    public void shouldScoreThrees() {
        assertEquals(3, score("THREES", new int[]{3, 4, 1, 5, 2}));
        assertEquals(9, score("THREES", new int[]{3, 1, 2, 3, 3}));
    }

    @Test
    public void shouldScoreFours() {
        assertEquals(12, score("FOURS", new int[]{4, 1, 3, 4, 4}));
        assertEquals(4, score("FOURS", new int[]{5, 2, 4, 1, 3}));
    }

    @Test
    public void shouldScoreFives() {
        assertEquals(10, score("FIVES", new int[]{5, 1, 3, 5, 4}));
        assertEquals(5, score("FIVES", new int[]{5, 2, 4, 1, 3}));
    }

    @Test
    public void shouldScoreSixes() {
        assertEquals(12, score("SIXES", new int[]{6, 1, 3, 6, 4}));
        assertEquals(6, score("SIXES", new int[]{6, 2, 4, 1, 3}));
    }

    @Test
    public void shouldScorePairs() {
        assertEquals(8, score("PAIRS", new int[]{4, 6, 4, 2, 1}));
        assertEquals(12, score("PAIRS", new int[]{6, 2, 1, 6, 3}));
    }

    @Test
    public void shouldScoreDoublePairs() {
        assertEquals(14, score("DOUBLEPAIRS", new int[]{2, 3, 2, 5, 5}));
        assertEquals(10, score("DOUBLEPAIRS", new int[]{1, 4, 1, 6, 4}));
    }

    @Test
    public void shouldScoreFullHouse() {
        assertEquals(19, score("FULLHOUSE", new int[]{5, 5, 5, 2, 2}));
    }

    @Test
    public void shouldScoreSmallStraight() {
        assertEquals(15, score("SMALLSTRAIGHT", new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void shouldScoreLargeStraight() {
        assertEquals(20, score("LARGESTRAIGHT", new int[]{2, 3, 4, 5, 6}));
    }

    @Test
    public void shouclScoreThreeOfAKind() {
        assertEquals(12, score("THREEOFAKIND", new int[]{4, 5, 4, 4, 2}));
    }

    @Test
    public void shouldScoreFourOfAKind() {
        assertEquals(20, score("FOUROFAKIND", new int[]{5, 1, 5, 5, 5}));
    }

    @Test
    public void shouldScoreFiveOfSame() {
        assertEquals(50, score("FIVEOFSAME", new int[]{3, 3, 3, 3, 3}));
    }

    //
    public int score(String categoryName, int[] dice) {

        // hidden array with frequencies of whatever occurs more than once
        int[] frequencies = new int[7];
        for (int die : dice) {
            frequencies[die]++;

        }
        if (categoryName == "ONES") {
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

        // score of pairs
        if (categoryName == "PAIRS") {
            return onePairDiceScore(frequencies);
        }

        // score of two pairs
        if (categoryName == "DOUBLEPAIRS") {
            return doublePairDiceScore(frequencies);
        }

        // score of full house = one pair and one triple
        if (categoryName == "FULLHOUSE") {
            return fullHouseScore(frequencies);
        }

        // small straight score
        if (categoryName == "SMALLSTRAIGHT") {
            return smallStraightScore(frequencies);
        }

        //
        if (categoryName == "LARGESTRAIGHT") {
            return largeStraightScore(frequencies);
        }

        if (categoryName == "THREEOFAKIND") {
            return threeOfAKindScore(frequencies);
        }

        if (categoryName == "FOUROFAKIND") {
            return fourOfAKindScore(frequencies);
        }

        //
        if (categoryName == "FIVEOFSAME") {
            return fiveOfSameScore(frequencies);
        }

        return 0;
    }

    // five of the same
    public int fiveOfSameScore(int[] frequencies) {
        for (int i = 1; frequencies.length > i; i++) {
            if (i == 5) ;
        }
        return 50;
    }

    // chance score
    public int sumOfAllDiceScore(int[] frequencies) {
        int score = 0;
        for (int i = 1; i < frequencies.length; i++) {
            score = score + (frequencies[i] * i);
        }
        return score;
    }


    // reusable code for three of a kind and four of a kind
    public int moreOfAKindScore(int[] frequencies, int numOfDice) {
        for (int i = frequencies.length - 1; i > 0; i--) {
            if (frequencies[i] >= numOfDice) {
                return i * numOfDice;
            }
        }
        return 0;
    }

    // Three of a kind
    public int threeOfAKindScore(int[] frequencies) {
        return moreOfAKindScore(frequencies, 3);
    }

    // Four of a kind
    public int fourOfAKindScore(int[] frequencies) {
        return moreOfAKindScore(frequencies, 4);
    }

    public static int calcChance(int[] dice) {
        int scoreAll = 0;
        for (int i = 1; i < dice.length; i++) {
            scoreAll += (dice[i] * i);
        }
        return scoreAll;
    }


    // Large straight score = 1, 2, 3, 4, 5, 6 = 20 score
    public static int largeStraightScore(int[] frequencies) {
        int largeStraight = 0;

        for (int i = 2; i < frequencies.length; i++) {
            if (frequencies[i] <= 2 && frequencies[i] > 0) {
                largeStraight++;
            }
        }

        if (largeStraight == 5) {
            return 20;
        }
        return 0;
    }

    // small straight score = 1, 2, 3, 4, 5 = 15 score
    public int smallStraightScore(int[] frequencies) {
        int smallStraight = 0;

        for (int i = 1; i < frequencies.length - 1; i++) {
            if (frequencies[i] <= 2 && frequencies[i] > 0) {
                smallStraight++;
            }
        }

        if (smallStraight == 5) {
            return 15;
        }
        return 0;
    }

    // fullHouseScore with the help of onePairDiceScore = one pair + triple
    public int fullHouseScore(int[] frequencies) {
        int firstHouse = onePairDiceScore(frequencies);
        int secHouse = 0;

        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] == 3) {
                secHouse = frequencies[i];
            }
        }

        if (firstHouse > 0 && secHouse > 0) {
            return 19;
        }
        return 0;

    }


    // Dice score based on two separate pairs, but favors highest occurrences if more pairs
    public int doublePairDiceScore(int[] frequencies) {
        for (int i = 1; frequencies.length > i; i++) {
            if (frequencies[i] > 1) {
                for (int j = 1; frequencies.length > j; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (frequencies[j] > 1) {
                        return (i * frequencies[i]) + (j * frequencies[j]);
                    }
                }
            }
        }
        return 0;
    }


    // Dice score based on pairs, could be two of 5 example
    public int onePairDiceScore(int[] frequencies) {
        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] > 1) {
                return i * 2;
            }
        }
        return 0;
    }

    // Dice score based on numbers between 1 and 6, but just single scores
    public int singleDiceScore(int diceValue, int[] frequencies) {
        for (int i = 1; i < frequencies.length; i++) {
            return frequencies[diceValue] * diceValue;
        }

        return 0;
    }
}


