package org.mreposa.statgen.view;

import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;
import org.mreposa.statgen.generator.AdndStatGenerator;

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

        JRadioButton method1 = new JRadioButton();
        method1.setText("3d6");
        method1.setActionCommand("3d6");
        method1.addActionListener(this);
        this.methodButtonGroup.add(method1);
        this.methodPanel.add(method1);

        JRadioButton method2 = new JRadioButton();
        method2.setText("3d6 plus updates");
        method2.setActionCommand("3d6 plus updates");
        method2.addActionListener(this);
        this.methodButtonGroup.add(method2);
        this.methodPanel.add(method2);

        JRadioButton method3 = new JRadioButton();
        method3.setText("5d6 best three");
        method3.setActionCommand("5d6 best three");
        method3.addActionListener(this);
        this.methodButtonGroup.add(method3);
        this.methodPanel.add(method3);

        JRadioButton method4 = new JRadioButton();
        method4.setText("4d6 drop lowest");
        method4.setActionCommand("4d6 drop lowest");
        method4.addActionListener(this);
        this.methodButtonGroup.add(method4);
        this.methodPanel.add(method4);

        JRadioButton method5 = new JRadioButton();
        method5.setText("3d6 six times take best");
        method5.setActionCommand("3d6 six times take best");
        method5.addActionListener(this);
        this.methodButtonGroup.add(method5);
        this.methodPanel.add(method5);

        // Set the default method
        this.methodButtonGroup.setSelected(method1.getModel(), true);
        this.selectedRace = "3d6";
    }

    @Override
    public String getDisplayStats(int[] stats) {
        StringBuilder output = new StringBuilder();

        if (stats != null) {
            output.append(this.selectedRace);
            output.append(" ");
            output.append(this.selectedClass);
            output.append("\n");
            output.append("ST ");
            output.append(stats[0]);

            // Display Exceptional ST value for Fighter, Paladin, Ranger, Cavalier, Cavalier Paladin, and Barbarian
            if (stats[0] == 18 &&
                    (this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[2]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[3]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[4]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[5]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[6]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[7]))) {
                output.append("/");
                output.append(stats[1]);
            }

            output.append(", ");
            output.append("IN ");
            output.append(stats[2]);
            output.append(", ");
            output.append("WI ");
            output.append(stats[3]);
            output.append(", ");
            output.append("DX ");
            output.append(stats[4]);
            output.append(", ");
            output.append("CO ");
            output.append(stats[5]);
            output.append(", ");
            output.append("CH ");
            output.append(stats[6]);
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
