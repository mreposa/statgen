package org.mreposa.statgen.model.adndrace;

public abstract class PlayerCharacterRace {
    public static final String[] AVAILABLE_RACES = {"Human", "Half-Elf", "Gnome", "Deep Gnome", "Hill Dwarf", "Mountain Dwarf", "Gray Dwarf", "High Elf", "Gray Elf", "Wood Elf", "Wild Elf", "Valley Elf", "Dark Elf", "Hairfoot Halfling", "Tallfellow Halfling", "Stout Halfling", "Half-Orc"};

    protected int[] updates = {0, 0, 0, 0, 0, 0, 0};
    protected int[] minimums = {3, 0, 3, 3, 3, 3, 3};

    public abstract int[] getUpdates();
    public abstract int[] getMinimums();

    public static PlayerCharacterRace getPlayerCharacterRace(String selectedRace) {
        PlayerCharacterRace pcRace = null;

        if (selectedRace != null) {
            switch (selectedRace) {
                case "Deep Gnome":
                case "Gnome": {
                    pcRace = new Gnome();
                    break;
                }
                case "Gray Dwarf":
                case "Mountain Dwarf":
                case "Hill Dwarf": {
                    pcRace = new Dwarf();
                    break;
                }
                case "Dark Elf":
                case "High Elf": {
                    pcRace = new HighElf();
                    break;
                }
                case "Valley Elf":
                case "Gray Elf": {
                    pcRace = new GrayElf();
                    break;
                }
                case "Wood Elf": {
                    pcRace = new WoodElf();
                    break;
                }
                case "Wild Elf": {
                    pcRace = new WildElf();
                    break;
                }
                case "Hairfoot Halfling":
                case "Tallfellow Halfling":
                case "Stout Halfling": {
                    pcRace = new Halfling();
                    break;
                }
                case "Half-Orc": {
                    pcRace = new HalfOrc();
                    break;
                }
                case "Half-Elf": {
                    pcRace = new HalfElf();
                    break;
                }
                default: {
                    pcRace = new Human();
                    break;
                }
            }
        }

        return pcRace;
    }
}
