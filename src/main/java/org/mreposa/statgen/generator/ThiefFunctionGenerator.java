package org.mreposa.statgen.generator;

import org.mreposa.statgen.model.adndthieffunction.ThiefFunctionTable;

public class ThiefFunctionGenerator {
    public double[] generate(int selectedLevel, int selectedRace, int selectedArmor, int selectedDexterity) {
        double[] results = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

        double[] thiefFunctions = ThiefFunctionTable.FUNCTION_VALUES_BY_LEVEL[selectedLevel];
        double[] raceMods = ThiefFunctionTable.FUNCTION_MODS_BY_RACE[selectedRace];
        double[] armorMods = ThiefFunctionTable.FUNCTION_MODS_BY_ARMOR[selectedArmor];
        double[] dexterityMods = ThiefFunctionTable.FUNCTION_MODS_BY_DEX[selectedDexterity];

        for (int i = 0; i < ThiefFunctionTable.AVAILABLE_FUNCTIONS.length; i++) {
            if (i == ThiefFunctionTable.FUNCTION_CW) {
                // Climb Walls is a special case
                results[i] = thiefFunctions[i];
                double totalMods = dexterityMods[i] + raceMods[i] + armorMods[i];

                if (totalMods != 0.0) {
                    if (totalMods > 0.0) {
                        // Add totalMods to results[i]
                        while (results[i] <= 99.0 && totalMods > 0.0) {
                            results[i] = results[i] + 1.0;
                            totalMods = totalMods - 1.0;
                        }
                        while (totalMods > 0.0) {
                            results[i] = results[i] + 0.1;
                            totalMods = totalMods - 1.0;
                        }

                        // Cap any result
                        if (results[i] > 99.9) {
                            results[i] = 99.9;
                        }
                    } else {
                        // Subtract totalMods from results[i]
                        while (results[i] >= 99.0 && totalMods < 0.0) {
                            results[i] = results[i] - 0.1;
                            totalMods = totalMods + 1.0;
                        }
                        while (totalMods < 0.0) {
                            results[i] = results[i] - 1.0;
                            totalMods = totalMods + 1.0;
                        }
                    }
                }
            }
            else {
                results[i] = thiefFunctions[i] + dexterityMods[i] + raceMods[i] + armorMods[i];
            }
        }

        return results;
    }
}
