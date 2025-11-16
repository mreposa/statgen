package org.mreposa.statgen.model.adnd.rollmethod;

import java.util.Random;

public class ThreeDSix extends StatMethod {
    public ThreeDSix() {
        super();
    }

    @Override
    public int generate(Random rand) {
        int total = 0;

        // Roll 3d6
        for (int i = 0; i < 3; i++) {
            total = total + rand.nextInt(6) + 1;
        }

        return total;
    }
}
