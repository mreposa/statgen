package org.mreposa.statgen.model.adndclass;

public abstract class PlayerCharacterClass {
    public static final String[] AVAILABLE_CLASSES = {"Cleric", "Druid", "Fighter", "Ranger", "Paladin", "Cavalier", "Cavalier Paladin", "Barbarian", "Magic-User", "Illusionist", "Thief", "Thief-Acrobat", "Assassin", "Monk", "Normal"};
    public static final int CLASS_CLERIC = 0;
    public static final int CLASS_DRUID = 1;
    public static final int CLASS_FIGHTER = 2;
    public static final int CLASS_RANGER = 3;
    public static final int CLASS_PALADIN = 4;
    public static final int CLASS_CAVALIER = 5;
    public static final int CLASS_CAVALIER_PALADIN = 6;
    public static final int CLASS_BARBARIAN = 7;
    public static final int CLASS_MAGIC_USER = 8;
    public static final int CLASS_ILLUSIONIST = 9;
    public static final int CLASS_THIEF = 10;
    public static final int CLASS_THIEF_ACROBAT = 11;
    public static final int CLASS_ASSASSIN = 12;
    public static final int CLASS_MONK = 13;
    public static final int CLASS_NORMAL = 14;

    public static final String[] AVAILABLE_STATS = {"STR", "ExSTR", "INT", "WIS", "DEX", "CON", "CHA", "COM"};
    public static final int STAT_STR = 0;
    public static final int STAT_EX_STR = 1;
    public static final int STAT_INT = 2;
    public static final int STAT_WIS = 3;
    public static final int STAT_DEX = 4;
    public static final int STAT_CON = 5;
    public static final int STAT_CHA = 6;
    public static final int STAT_COM = 7;

    public static final int MAX_STAT_VALUE = 18;
    public static final int MAX_COM_STAT_VALUE = 25;
    public static final int MAX_WIS_STAT_BARBARIAN = 16;

    protected static final int PRIMARY_UPDATE_VALUE = 3;
    protected static final int SECONDARY_UPDATE_VALUE = 2;
    protected static final int TERTIARY_UPDATE_VALUE = 1;
    protected int[] updates;

    public static final int DEFAULT_STAT_VALUE = 3;
    protected static final int DEFAULT_EX_STR_VALUE = 0;
    protected int[] minimums;

    public PlayerCharacterClass() {
        updates = new int[AVAILABLE_STATS.length];
        minimums = new int[AVAILABLE_STATS.length];

        for (int a = 0; a < AVAILABLE_STATS.length; a++) {
            updates[a] = 0;

            if (a == 1) {
                minimums[a] = DEFAULT_EX_STR_VALUE;
            }
            else {
                minimums[a] = DEFAULT_STAT_VALUE;
            }
        }
    }

    public abstract int[] getUpdates();
    public abstract int[] getMinimums();

    public static PlayerCharacterClass getPlayerCharacterClass(String selectedClass) {
        PlayerCharacterClass pcClass = null;

        if (selectedClass != null) {
            if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_CLERIC])) {
                pcClass = new Cleric();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_DRUID])) {
                pcClass = new Druid();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_FIGHTER])) {
                pcClass = new Fighter();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_RANGER])) {
                pcClass = new Ranger();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_PALADIN])) {
                pcClass = new Paladin();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_CAVALIER])) {
                pcClass = new Cavalier();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_CAVALIER_PALADIN])) {
                pcClass = new CavalierPaladin();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_BARBARIAN])) {
                pcClass = new Barbarian();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_MAGIC_USER])) {
                pcClass = new MagicUser();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_ILLUSIONIST])) {
                pcClass = new Illusionist();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_THIEF])) {
                pcClass = new Thief();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_THIEF_ACROBAT])) {
                pcClass = new ThiefAcrobat();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_ASSASSIN])) {
                pcClass = new Assassin();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_MONK])) {
                pcClass = new Monk();
            }
            else if (selectedClass.equals(AVAILABLE_CLASSES[CLASS_NORMAL])) {
                pcClass = new Normal();
            }
            else {
                pcClass = new Cleric();
            }
        }

        return pcClass;
    }
}
