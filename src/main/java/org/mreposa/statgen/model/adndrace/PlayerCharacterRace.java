package org.mreposa.statgen.model.adndrace;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;

public abstract class PlayerCharacterRace {
    public static final String[] AVAILABLE_RACES = {"Human", "Half-Elf", "Gnome", "Deep Gnome", "Hill Dwarf", "Mountain Dwarf", "Gray Dwarf", "High Elf", "Dark Elf", "Gray Elf", "Valley Elf", "Wood Elf", "Wild Elf", "Hairfoot Halfling", "Tallfellow Halfling", "Stout Halfling", "Half-Orc"};
    public static final int RACE_HUMAN = 0;
    public static final int RACE_HALF_ELF = 1;
    public static final int RACE_GNOME = 2;
    public static final int RACE_DEEP_GNOME = 3;
    public static final int RACE_HILL_DWARF = 4;
    public static final int RACE_MOUNTAIN_DWARF = 5;
    public static final int RACE_GRAY_DWARF = 6;
    public static final int RACE_HIGH_ELF = 7;
    public static final int RACE_DARK_ELF = 8;
    public static final int RACE_GRAY_ELF = 9;
    public static final int RACE_VALLEY_ELF = 10;
    public static final int RACE_WOOD_ELF = 11;
    public static final int RACE_WILD_ELF = 12;
    public static final int RACE_HAIRFOOT_HALFLING = 13;
    public static final int RACE_TALLFELLOW_HALFLINGL = 14;
    public static final int RACE_STOUT_HALFLING = 15;
    public static final int RACE_HALF_ORC = 16;

    protected int[] updates;
    protected int[] minimums;

    public PlayerCharacterRace() {
        updates = new int[PlayerCharacterClass.AVAILABLE_STATS.length];
        minimums = new int[PlayerCharacterClass.AVAILABLE_STATS.length];

        for (int a = 0; a < PlayerCharacterClass.AVAILABLE_STATS.length; a++) {
            updates[a] = 0;
            minimums[a] = PlayerCharacterClass.DEFAULT_STAT_VALUE;
        }
    }

    public abstract int[] getUpdates();
    public abstract int[] getMinimums();

    public static PlayerCharacterRace getPlayerCharacterRace(String selectedRace) {
        PlayerCharacterRace pcRace = null;

        if (selectedRace != null) {
            if (selectedRace.equals(AVAILABLE_RACES[RACE_HUMAN])) {
                pcRace = new Human();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_HALF_ELF])) {
                pcRace = new HalfElf();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_GNOME]) || selectedRace.equals(AVAILABLE_RACES[RACE_DEEP_GNOME])) {
                pcRace = new Gnome();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_HILL_DWARF]) || selectedRace.equals(AVAILABLE_RACES[RACE_MOUNTAIN_DWARF]) || selectedRace.equals(AVAILABLE_RACES[RACE_GRAY_DWARF])) {
                pcRace = new Dwarf();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_HIGH_ELF]) || selectedRace.equals(AVAILABLE_RACES[RACE_DARK_ELF])) {
                pcRace = new HighElf();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_GRAY_ELF]) || selectedRace.equals(AVAILABLE_RACES[RACE_VALLEY_ELF])) {
                pcRace = new GrayElf();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_WOOD_ELF])) {
                pcRace = new WoodElf();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_WILD_ELF])) {
                pcRace = new WildElf();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_HAIRFOOT_HALFLING]) || selectedRace.equals(AVAILABLE_RACES[RACE_TALLFELLOW_HALFLINGL]) || selectedRace.equals(AVAILABLE_RACES[RACE_STOUT_HALFLING])) {
                pcRace = new Halfling();
            }
            else if (selectedRace.equals(AVAILABLE_RACES[RACE_HALF_ORC])) {
                pcRace = new HalfOrc();
            }
            else {
                pcRace = new Human();
            }
        }

        return pcRace;
    }
}
