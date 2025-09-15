package org.mreposa.statgen.model.adndrace;

public class Dwarf extends PlayerCharacterRace {
    public Dwarf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[5] = 1;
        updates[6] = -1;
        return updates;
    }
}
