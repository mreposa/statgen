package org.mreposa.statgen.model.adndrace;

public class HighElf extends PlayerCharacterRace {
    public HighElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[4] = 1;
        updates[5] = -1;
        return updates;
    }
}
