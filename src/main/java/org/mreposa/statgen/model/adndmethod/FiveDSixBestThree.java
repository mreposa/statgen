package org.mreposa.statgen.model.adndmethod;

import java.util.Random;

public class FiveDSixBestThree extends StatMethod {
    public FiveDSixBestThree() {
        super();
    }
    public int generate(Random rand) {
        int total = 0;
        int[] rolls = new int[5];

        // Roll 5d6, take best three
        for (int i = 0; i < 5; i++) {
            rolls[i] = rand.nextInt(6) + 1;
        }

        java.util.Arrays.sort(rolls);

        total = rolls[4] + rolls[3] + rolls[2];

        return total;
    }
}
