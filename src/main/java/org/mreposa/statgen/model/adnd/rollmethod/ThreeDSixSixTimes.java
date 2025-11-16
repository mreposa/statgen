package org.mreposa.statgen.model.adnd.rollmethod;

import java.util.Random;

public class ThreeDSixSixTimes extends StatMethod {
    public ThreeDSixSixTimes() {
        super();
    }

    @Override
    public int generate(Random rand) {
        int total = 0;
        int[] rolls = new int[6];

        // Roll 3d6 six times, take best
        for (int r = 0; r < 6; r++) {
            for (int i = 0; i < 3; i++) {
                total = total + rand.nextInt(6) + 1;
            }
            rolls[r] = total;
            total = 0;
        }

        java.util.Arrays.sort(rolls);

        total = rolls[5];

        return total;
    }
}
