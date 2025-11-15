package org.mreposa.statgen.generator;

import java.util.Random;

public abstract class DiceRollGenerator {
    private final Random rand;

    public DiceRollGenerator() {
        this.rand = new Random(System.currentTimeMillis());
    }

    public abstract int[] getDice();

    public int roll(int diceCount, int diceSides) {
        int total = 0;
        int roll = 0;

        for (int i = 0; i < diceCount; i++) {
            roll = this.rand.nextInt(diceSides) + 1;
            total = total + roll;
        }

        return total;
    }
}
