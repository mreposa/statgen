package org.mreposa.statgen.generator.adnd;

public class DiceRollGenerator extends org.mreposa.statgen.generator.DiceRollGenerator {
    private static final int[] DICE_SIDES = {4, 6, 8, 10, 12, 20, 100};

    public DiceRollGenerator() { super(); }

    @Override
    public int[] getDice() {
        return DICE_SIDES;
    }
}
