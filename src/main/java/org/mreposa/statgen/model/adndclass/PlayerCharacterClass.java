package org.mreposa.statgen.model.adndclass;

public abstract class PlayerCharacterClass {
    public static final String[] AVAILABLE_CLASSES = {"Cleric", "Druid", "Fighter", "Ranger", "Paladin", "Cavalier", "Cavalier Paladin", "Barbarian", "Magic-User", "Illusionist", "Thief", "Thief-Acrobat", "Assassin", "Monk", "Normal"};
    public static final int STAT_COUNT = 7; // {Strength, Exceptional Strength, Intelligence, Wisdom, Dexterity, Constitution, Charisma}
    public static final int MAX_STAT_VALUE = 18;

    protected static final int PRIMARY_UPDATE_VALUE = 3;
    protected static final int SECONDARY_UPDATE_VALUE = 2;
    protected static final int TERTIARY_UPDATE_VALUE = 1;
    protected int[] updates = {0, 0, 0, 0, 0, 0, 0};

    protected static final int DEFAULT_STAT_VALUE = 9;
    protected static final int DEFAULT_EX_ST_VALUE = 0;
    protected int[] minimums = {DEFAULT_STAT_VALUE, DEFAULT_EX_ST_VALUE, DEFAULT_STAT_VALUE, DEFAULT_STAT_VALUE, DEFAULT_STAT_VALUE, DEFAULT_STAT_VALUE, DEFAULT_STAT_VALUE};

    public abstract int[] getUpdates();
    public abstract int[] getMinimums();

    public static PlayerCharacterClass getPlayerCharacterClass(String selectedClass) {
        PlayerCharacterClass pcClass = null;

        if (selectedClass != null) {
            switch (selectedClass) {
                case "Cleric": {
                    pcClass = new Cleric();
                    break;
                }
                case "Druid": {
                    pcClass = new Druid();
                    break;
                }
                case "Fighter": {
                    pcClass = new Fighter();
                    break;
                }
                case "Paladin": {
                    pcClass = new Paladin();
                    break;
                }
                case "Ranger": {
                    pcClass = new Ranger();
                    break;
                }
                case "Cavalier": {
                    pcClass = new Cavalier();
                    break;
                }
                case "Cavalier Paladin": {
                    pcClass = new CavalierPaladin();
                    break;
                }
                case "Barbarian": {
                    pcClass = new Barbarian();
                    break;
                }
                case "Magic-User": {
                    pcClass = new MagicUser();
                    break;
                }
                case "Illusionist": {
                    pcClass = new Illusionist();
                    break;
                }
                case "Thief": {
                    pcClass = new Thief();
                    break;
                }
                case "Thief-Acrobat": {
                    pcClass = new ThiefAcrobat();
                    break;
                }
                case "Assassin": {
                    pcClass = new Assassin();
                    break;
                }
                case "Monk": {
                    pcClass = new Monk();
                    break;
                }
                default: {
                    pcClass = new Normal();
                    break;
                }
            }
        }

        return pcClass;
    }
}
