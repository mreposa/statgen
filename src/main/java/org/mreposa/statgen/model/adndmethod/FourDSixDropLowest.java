package org.mreposa.statgen.model.adndmethod;

import java.util.Random;

public class FourDSixDropLowest implements StatMethod {
    public int generate(Random rand) {
        int total = 0;
        int[] rolls = new int[4];

        // Roll 4d6, drop the lowest
        for (int i = 0; i < 4; i++) {
            rolls[i] = rand.nextInt(6) + 1;
        }

        java.util.Arrays.sort(rolls);

        total = rolls[3] + rolls[2] + rolls[1];

        return total;
    }
}
