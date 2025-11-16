package org.mreposa.statgen.model.adnd.race;

import org.mreposa.statgen.model.adnd.playerclass.PlayerCharacterClass;

public class Gnome extends PlayerCharacterRace {
    public Gnome() { super(); }

    @Override
    public int[] getUpdates() {
        updates[PlayerCharacterClass.STAT_COM] = -1;
        return updates;
    }

    @Override
    public int[] getMinimums() {
        minimums[PlayerCharacterClass.STAT_STR] = 6;
        minimums[PlayerCharacterClass.STAT_INT] = 7;
        minimums[PlayerCharacterClass.STAT_CON] = 8;
        return minimums;
    }
}
