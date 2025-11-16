package org.mreposa.statgen.view.adnd;

import org.mreposa.statgen.generator.adnd.ThiefFunctionGenerator;
import org.mreposa.statgen.model.adnd.playerclass.ThiefFunctionTable;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;

public class AdndThiefFunctionPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final JComboBox<String> level;
    private final JComboBox<String> race;
    private final JComboBox<String> armor;
    private final JComboBox<String> dexterity;
    private final JEditorPane display;

    public AdndThiefFunctionPanel() {
        super();

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label1 = new JLabel("Level:");
        selectionPanel.add(label1);

        this.level = new JComboBox<>(ThiefFunctionTable.AVAILABLE_LEVELS);
        this.level.setSelectedIndex(0);
        selectionPanel.add(this.level);

        JLabel label2 = new JLabel("Race:");
        selectionPanel.add(label2);

        this.race = new JComboBox<>(ThiefFunctionTable.AVAILABLE_RACES);
        this.race.setSelectedIndex(0);
        selectionPanel.add(this.race);

        JLabel label3 = new JLabel("Armor:");
        selectionPanel.add(label3);

        this.armor = new JComboBox<>(ThiefFunctionTable.AVAILABLE_ARMOR);
        this.armor.setSelectedIndex(1);
        selectionPanel.add(this.armor);

        JLabel label4 = new JLabel("Dexterity:");
        selectionPanel.add(label4);

        this.dexterity = new JComboBox<>(ThiefFunctionTable.AVAILABLE_DEXTERITY);
        this.dexterity.setSelectedIndex(0);
        selectionPanel.add(this.dexterity);

        JButton generateButton = new JButton("Get");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> getThiefFunctions());
        selectionPanel.add(generateButton);

        JButton clearButton = new JButton("Clear");
        Dimension bd2 = new Dimension(90, 20);
        clearButton.setSize(bd2);
        clearButton.setPreferredSize(bd2);
        clearButton.setMaximumSize(bd2);
        clearButton.addActionListener(_ -> clearDisplay());
        selectionPanel.add(clearButton);

        this.display = new JEditorPane();
        this.display.setEditable(false);

        add(selectionPanel, BorderLayout.NORTH);
        add(this.display, BorderLayout.CENTER);
    }

    private void getThiefFunctions() {
        int selectedLevel = this.level.getSelectedIndex();
        int selectedRace = this.race.getSelectedIndex();
        int selectedArmor = this.armor.getSelectedIndex();
        int selectedDexterity = this.dexterity.getSelectedIndex();

        ThiefFunctionGenerator generator = new ThiefFunctionGenerator();
        double[] functions = generator.generate(selectedLevel, selectedRace, selectedArmor, selectedDexterity);

        String displayFunctions = displayFunctions(functions);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), displayFunctions, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String displayFunctions(double[] functionValues) {
        StringBuilder output = new StringBuilder();

        if (functionValues != null) {
            for (int i = 0; i < ThiefFunctionTable.AVAILABLE_FUNCTIONS.length - 1; i++) {
                output.append(ThiefFunctionTable.AVAILABLE_FUNCTIONS[i]);
                output.append(" ");

                if (i == ThiefFunctionTable.FUNCTION_CW) {
                    // Climb Walls is a special case
                    if (functionValues[i] < 99.0) {
                        output.append((int) functionValues[i]);
                    }
                    else {
                        output.append(functionValues[i]);
                    }
                }
                else {
                    output.append((int) functionValues[i]);
                }
                output.append("%");

                output.append(", ");
            }

            output.append(ThiefFunctionTable.AVAILABLE_FUNCTIONS[ThiefFunctionTable.AVAILABLE_FUNCTIONS.length - 1]);
            output.append(" x");
            output.append((int) functionValues[ThiefFunctionTable.AVAILABLE_FUNCTIONS.length - 1]);

            output.append("\n\n");
        }
        else {
            output.append("Missing functions\n\n");
        }

        return output.toString();
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
