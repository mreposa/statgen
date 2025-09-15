package org.mreposa.statgen.model.adndmethod;

import java.util.Random;

public class ThreeDSix implements StatMethod {
    public int generate(Random rand) {
        int total = 0;

        // Roll 3d6
        for (int i = 0; i < 3; i++) {
            total = total + rand.nextInt(6) + 1;
        }

        return total;
    }
}
