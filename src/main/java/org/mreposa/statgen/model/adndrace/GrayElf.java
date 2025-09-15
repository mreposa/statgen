package org.mreposa.statgen.model.adndrace;

public class GrayElf extends PlayerCharacterRace {
    public GrayElf() { super(); }

    @Override
    public int[] getUpdates() {
        updates[2] = 1;
        updates[5] = -1;
        return updates;
    }
}
