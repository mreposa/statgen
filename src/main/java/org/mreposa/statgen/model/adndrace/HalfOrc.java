package org.mreposa.statgen.model.adndrace;

public class HalfOrc extends PlayerCharacterRace {
    public HalfOrc() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = 1;
        updates[5] = 1;
        updates[6] = -2;
        return updates;
    }
}
