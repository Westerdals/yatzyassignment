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
        return new Yatzy(categoryName, dice).calcScore();

    }


}


