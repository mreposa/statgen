package org.mreposa.statgen.view;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;
import org.mreposa.statgen.generator.AdndStatGenerator;
import org.mreposa.statgen.model.adndmethod.StatMethod;

import javax.swing.*;
import java.awt.*;

public class AdndStatFrame extends StatFrame {
    private static final String APP_VERSION = "1.0.0";
    private static final String APP_TITLE = "AD&D Stat Generator";
    private static final String ABOUT_MESSAGE = APP_TITLE + "\nVersion " + APP_VERSION + "\n" + "Michael Reposa\n" + "27-AUG-2025";

    public AdndStatFrame() {
        super();
        this.setTitle(APP_TITLE);
        this.statGenerator = new AdndStatGenerator();

        for (int a = 0; a < StatMethod.AVAILABLE_METHODS.length; a++) {
            JRadioButton btn = new JRadioButton();
            btn.setText(StatMethod.AVAILABLE_METHODS[a]);
            btn.setActionCommand(StatMethod.AVAILABLE_METHODS[a]);
            this.methodButtonGroup.add(btn);
            this.methodPanel.add(btn);
            if (a == 0) {
                this.methodButtonGroup.setSelected(btn.getModel(), true);
                this.selectedMethod = StatMethod.AVAILABLE_METHODS[0];
            }
        }

        this.tabs.add("Thief Functions", new ThiefFunctionPanel());
    }

    @Override
    public String getDisplayStats(int[] stats) {
        StringBuilder output = new StringBuilder();

        if (stats != null) {
            output.append(this.selectedRace);
            output.append(" ");
            output.append(this.selectedClass);
            output.append("\n");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_STR]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_STR]);

            // Display Exceptional ST value for Fighter, Ranger, Paladin, Cavalier, Cavalier Paladin, and Barbarian
            if (stats[PlayerCharacterClass.STAT_STR] == PlayerCharacterClass.MAX_STAT_VALUE &&
                    (this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_FIGHTER]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_RANGER]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_PALADIN]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_CAVALIER]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_CAVALIER_PALADIN]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_BARBARIAN]))) {
                output.append("/");
                output.append(stats[PlayerCharacterClass.STAT_EX_STR]);
            }

            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_INT]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_INT]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_WIS]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_WIS]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_DEX]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_DEX]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_CON]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_CON]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_CHA]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_CHA]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_COM]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_COM]);
            output.append("\n\n");
        }
        else {
            output.append("Missing stats\n\n");
        }

        return output.toString();
    }

    @Override
    public String getAbout() {
        return ABOUT_MESSAGE;
    }
}
