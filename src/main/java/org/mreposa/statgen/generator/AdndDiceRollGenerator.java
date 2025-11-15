package org.mreposa.statgen.generator;

public class AdndDiceRollGenerator extends DiceRollGenerator {
    private static final int[] DICE_SIDES = {4, 6, 8, 10, 12, 20, 100};

    public AdndDiceRollGenerator() { super(); }

    @Override
    public int[] getDice() {
        return DICE_SIDES;
    }
}
