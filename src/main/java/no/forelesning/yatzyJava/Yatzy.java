package no.forelesning.yatzyJava;

class Yatzy {
    private String categoryName;
    private int[] dice;

    public Yatzy(String categoryName, int... dice) {
        this.categoryName = categoryName;
        this.dice = dice;
    }

    public int calcScore() {
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

    public int calcChance(int[] dice) {
        int scoreAll = 0;
        for (int i = 1; i < dice.length; i++) {
            scoreAll += (dice[i] * i);
        }
        return scoreAll;
    }


    // Large straight score = 1, 2, 3, 4, 5, 6 = 20 score
    public int largeStraightScore(int[] frequencies) {
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
