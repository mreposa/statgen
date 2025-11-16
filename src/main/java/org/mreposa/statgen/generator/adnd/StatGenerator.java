package org.mreposa.statgen.generator.adnd;

import org.mreposa.statgen.model.adnd.playerclass.PlayerCharacterClass;
import org.mreposa.statgen.model.adnd.rollmethod.*;
import org.mreposa.statgen.model.adnd.race.PlayerCharacterRace;

import java.util.Random;

public class StatGenerator implements org.mreposa.statgen.generator.StatGenerator {
    private final Random rand;

    public StatGenerator() {
        super();
        this.rand = new Random(System.currentTimeMillis());
    }

    @Override
    public int[] generate(String selectedClass, String selectedRace, String selectedMethod) {
        int[] stats = new int[PlayerCharacterClass.AVAILABLE_STATS.length];

        if (selectedClass != null && selectedRace != null && selectedMethod != null && !selectedMethod.isBlank()) {
            PlayerCharacterClass pcClass = PlayerCharacterClass.getPlayerCharacterClass(selectedClass);
            PlayerCharacterRace pcRace = PlayerCharacterRace.getPlayerCharacterRace(selectedRace);

            int[] classUpdates = pcClass.getUpdates();
            int[] classMinimums = pcClass.getMinimums();
            int[] raceUpdates = pcRace.getUpdates();
            int[] raceMinimums = pcRace.getMinimums();

            int total;
            StatMethod method;

            for (int statSlot = 0; statSlot < PlayerCharacterClass.AVAILABLE_STATS.length; statSlot++) {
                // Generate base stat value
                if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[1])) {
                    method = new ThreeDSix();
                    total = method.generate(this.rand);

                    // Adjust stats using class updates
                    total = total + classUpdates[statSlot];
                }
                else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[2])) {
                    method = new FiveDSixBestThree();
                    total = method.generate(this.rand);
                }
                else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[3])) {
                    method = new FourDSixDropLowest();
                    total = method.generate(this.rand);
                }
                else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[4])) {
                    method = new ThreeDSixSixTimes();
                    total = method.generate(this.rand);
                }
                else {
                    method = new ThreeDSix();
                    total = method.generate(this.rand);
                }

                if (total > PlayerCharacterClass.MAX_STAT_VALUE) {
                    total = PlayerCharacterClass.MAX_STAT_VALUE;
                }

                // Adjust stat for race (allows for stat to be higher than PlayerCharacterClass.MAX_STAT_VALUE)
                total = total + raceUpdates[statSlot];
                if (total < raceMinimums[statSlot]) {
                    total = raceMinimums[statSlot];
                }

                switch (statSlot) {
                    case PlayerCharacterClass.STAT_EX_STR: {
                        // Generate Exceptional ST value (0 - 100)
                        if (stats[PlayerCharacterClass.STAT_STR] == PlayerCharacterClass.MAX_STAT_VALUE) {
                            total = this.rand.nextInt(100) + 1;
                        } else {
                            total = 0;
                        }
                        break;
                    }
                    case PlayerCharacterClass.STAT_WIS: {
                        // Cap Wisdom for Barbarian
                        if (selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_BARBARIAN]) && total > PlayerCharacterClass.MAX_WIS_STAT_BARBARIAN) {
                            total = PlayerCharacterClass.MAX_WIS_STAT_BARBARIAN;
                        }
                        break;
                    }
                    case PlayerCharacterClass.STAT_COM: {
                        // Adjust Comeliness for Charisma
                        if (stats[PlayerCharacterClass.STAT_CHA] < 3) {
                            total = total - 8;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] == 3) {
                            total = total - 5;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] == 4 || stats[PlayerCharacterClass.STAT_CHA] == 5) {
                            total = total - 3;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] == 6 || stats[PlayerCharacterClass.STAT_CHA] == 7 || stats[PlayerCharacterClass.STAT_CHA] == 8) {
                            total = total - 1;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] == 13 || stats[PlayerCharacterClass.STAT_CHA] == 14 || stats[PlayerCharacterClass.STAT_CHA] == 15) {
                            total = total + 1;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] == 16 || stats[PlayerCharacterClass.STAT_CHA] == 17) {
                            total = total + 2;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] == 18) {
                            total = total + 3;
                        }
                        else if (stats[PlayerCharacterClass.STAT_CHA] > 18) {
                            total = total + 5;
                        }

                        // Cap Comeliness for character from the Prime Material Plane
                        if (total > PlayerCharacterClass.MAX_COM_STAT_VALUE) {
                            total = PlayerCharacterClass.MAX_COM_STAT_VALUE;
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }

                // Adjust minimum stats for class to ensure selected class minimums are met
                if (total < classMinimums[statSlot]) {
                    total = classMinimums[statSlot];
                }

                stats[statSlot] = total;
            }
        }

        return stats;
    }
}
