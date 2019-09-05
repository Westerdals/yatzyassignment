import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class test {

    @Test
    public void shouldScoreOnes() {
        assertEquals(4, score("ONES", new int[] { 2, 1, 1, 1, 1} ));
        assertEquals(4, score("ONES", new int[] { 2, 1, 2, 2, 1 }));
    }

    @Test
    void shouldScoreTwos() {
        assertEquals(0, score("TWOS", new int[] { 1, 3, 4, 5, 6 }));
        assertEquals(2, score("TWOS", new int[] { 2, 1, 2, 2, 1 }));
    }

    @Test
    void shouldScoreThrees() {
        assertEquals(0, score("THREES", new int[] { 1, 2, 4, 5, 6 }));
        assertEquals(2, score("THREES", new int[] { 3, 3, 3, 2, 1 }));
    }

    @Test
    void shouldScorePair() {
        assertEquals(0, score("PAIR", new int[] { 1, 2, 3, 5, 6 }));
        assertEquals(2, score("PAIR", new int[] { 3, 2, 3, 4, 1 }));
        assertEquals(2, score("PAIR", new int[] { 3, 2, 3, 4, 1 }));
    }



    private int score(String category, int[] dice); {
        return 0;
        }


    }

}

