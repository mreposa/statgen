package org.mreposa.statgen.view;

import org.mreposa.statgen.generator.ThiefFunctionGenerator;
import org.mreposa.statgen.model.adndthieffunction.ThiefFunctionTable;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;

public class ThiefFunctionFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 400;

    private final JComboBox<String> level;
    private final JComboBox<String> race;
    private final JComboBox<String> armor;
    private final JComboBox<String> dexterity;
    private final JEditorPane displayArea;

    public ThiefFunctionFrame() {
        super();

        this.setTitle("Thief Functions");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        basePanel.setSize(d);
        basePanel.setPreferredSize(d);
        add(basePanel);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout());
        basePanel.add(selectionPanel, BorderLayout.NORTH);

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

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        this.displayArea = new JEditorPane();
        this.displayArea.setSize(d);
        this.displayArea.setPreferredSize(d);
        displayPanel.add(this.displayArea);

        basePanel.add(displayPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    private void getThiefFunctions() {
        int selectedLevel = this.level.getSelectedIndex();
        int selectedRace = this.race.getSelectedIndex();
        int selectedArmor = this.armor.getSelectedIndex();
        int selectedDexterity = this.dexterity.getSelectedIndex();

        ThiefFunctionGenerator generator = new ThiefFunctionGenerator();
        double[] functions = generator.generate(selectedLevel, selectedRace, selectedArmor, selectedDexterity);

        String displayFunctions = getDisplayFunctions(functions);

        try {
            Document doc = this.displayArea.getDocument();
            doc.insertString(doc.getLength(), displayFunctions, null);
        } catch (BadLocationException ble) {
            this.displayArea.setText("ERROR: " + ble.getMessage());
        }
    }

    public String getDisplayFunctions(double[] functionValues) {
        StringBuilder output = new StringBuilder();

        if (functionValues != null) {
            for (int i = 0; i < ThiefFunctionTable.AVAILABLE_FUNCTIONS.length; i++) {
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

                if (i < ThiefFunctionTable.AVAILABLE_FUNCTIONS.length - 1) {
                    output.append(", ");
                }
            }

            output.append("\n\n");
        }
        else {
            output.append("Missing functions\n\n");
        }

        return output.toString();
    }

    private void clearDisplay() {
        this.displayArea.setText("");
    }
}
