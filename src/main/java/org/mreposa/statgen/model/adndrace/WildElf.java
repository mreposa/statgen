package org.mreposa.statgen.model.adndrace;

public class WildElf extends PlayerCharacterRace {
    public WildElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[0] = 2;
        updates[6] = -2;
        return updates;
    }
}
