package org.mreposa.statgen.model.adndrace;

public class Halfling extends PlayerCharacterRace {
    public Halfling() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = -1;
        updates[4] = 1;
        return updates;
    }
}
