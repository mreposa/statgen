package org.mreposa.statgen.generator;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;
import org.mreposa.statgen.model.adndmethod.*;
import org.mreposa.statgen.model.adndrace.PlayerCharacterRace;

import java.util.Random;

public class AdndStatGenerator implements StatGenerator {
    public AdndStatGenerator() {
        super();
    }

    @Override
    public int[] generate(String selectedClass, String selectedRace, String selectedMethod) {
        int[] stats = new int[PlayerCharacterClass.STAT_COUNT];

        if (selectedClass != null && selectedRace != null && selectedMethod != null && !selectedMethod.isBlank()) {
            PlayerCharacterClass pcClass = PlayerCharacterClass.getPlayerCharacterClass(selectedClass);
            PlayerCharacterRace pcRace = PlayerCharacterRace.getPlayerCharacterRace(selectedRace);

            int[] classUpdates = pcClass.getUpdates();
            int[] classMinimums = pcClass.getMinimums();
            int[] raceUpdates = pcRace.getUpdates();
            int[] raceMinimums = pcRace.getMinimums();

            Random rand = new Random();
            int total = 0;
            StatMethod method;

            for (int statSlot = 0; statSlot < PlayerCharacterClass.STAT_COUNT; statSlot++) {

                switch (selectedMethod) {
                    case "3d6": {
                        method = new ThreeDSix();
                        total = method.generate(rand);

                        break;
                    }
                    case "3d6 plus updates": {
                        method = new ThreeDSix();
                        total = method.generate(rand);

                        // Adjust stats using class updates
                        total = total + classUpdates[statSlot];

                        break;
                    }
                    case "5d6 best three": {
                        method = new FiveDSixBestThree();
                        total = method.generate(rand);

                        break;
                    }
                    case "4d6 drop lowest": {
                        method = new FourDSixDropLowest();
                        total = method.generate(rand);

                        break;
                    }
                    case "3d6 six times take best": {
                        method = new ThreeDSixSixTimes();
                        total = method.generate(rand);

                        break;
                    }
                    default: {
                        break;
                    }
                }

                if (total < classMinimums[statSlot]) {
                    total = classMinimums[statSlot];
                }

                if (total > PlayerCharacterClass.MAX_STAT_VALUE) {
                    total = PlayerCharacterClass.MAX_STAT_VALUE;
                }

                // Adjust stats for race (allows for a stat to be 19)
                total = total + raceUpdates[statSlot];

                if (total < raceMinimums[statSlot]) {
                    total = raceMinimums[statSlot];
                }

                // Cap Wisdom to 16 for Barbarian
                if (statSlot == 3 && selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[7])) {
                    if (total > 16) {
                        total = 16;
                    }
                }

                // Generate Exceptional ST value (0 - 100)
                if (statSlot == 1) {
                    if (stats[0] == 18) {
                        total = rand.nextInt(100) + 1;
                    } else {
                        total = 0;
                    }
                }

                stats[statSlot] = total;

                total = 0;
            }
        }

        return stats;
    }
}
