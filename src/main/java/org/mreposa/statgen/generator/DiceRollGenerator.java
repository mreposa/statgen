package org.mreposa.statgen.generator;

import org.mreposa.statgen.model.roll.Roll;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class DiceRollGenerator {
    public static final int MIN_DICE_COUNT = 1;
    public static final int MAX_DICE_COUNT = 99;
    public static final int MIN_DICE_SIDES = 2;
    public static final int MAX_DICE_SIDES = 100;

    private final Random rand;

    public DiceRollGenerator() {
        this.rand = new Random(System.currentTimeMillis());
    }

    public abstract int[] getDice();

    public Roll roll(int diceCount, int diceSides) {
        // Constrain dice count
        if (diceCount < MIN_DICE_COUNT) {
            diceCount = MIN_DICE_COUNT;
        }
        else if (diceCount > MAX_DICE_COUNT) {
            diceCount = MAX_DICE_COUNT;
        }

        // Constrain dice sides
        if (diceSides < MIN_DICE_SIDES) {
            diceSides = MIN_DICE_SIDES;
        }
        else if (diceSides > MAX_DICE_SIDES) {
            diceSides = MAX_DICE_SIDES;
        }

        int total = 0;
        int value;
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < diceCount; i++) {
            value = this.rand.nextInt(diceSides) + 1;
            values.add(value);
            total = total + value;
        }

        Roll roll = new Roll();
        roll.setTotal(total);
        roll.setValues(values);

        return roll;
    }
}
