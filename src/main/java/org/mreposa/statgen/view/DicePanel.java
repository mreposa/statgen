package org.mreposa.statgen.view;

import org.mreposa.statgen.generator.DiceRollGenerator;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;

public class DicePanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final DiceRollGenerator rollGenerator;
    private final ButtonGroup diceButtonGroup;
    private final JTextField diceNumber;
    private final JEditorPane display;

    public DicePanel(DiceRollGenerator rollGenerator) {
        super();

        this.rollGenerator = rollGenerator;
        int[] dice = this.rollGenerator.getDice();

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label1 = new JLabel("Number:");
        selectionPanel.add(label1);

        this.diceNumber = new JTextField("1");
        this.diceNumber.setColumns(3);
        selectionPanel.add(this.diceNumber);

        this.diceButtonGroup = new ButtonGroup();
        for (int a = 0; a < dice.length; a++) {
            JRadioButton btn = new JRadioButton();
            btn.setText("d" + dice[a]);
            btn.setActionCommand(Integer.toString(dice[a]));
            this.diceButtonGroup.add(btn);
            selectionPanel.add(btn);
            if (a == 1) {
                this.diceButtonGroup.setSelected(btn.getModel(), true);
            }
        }

        JButton generateButton = new JButton("Roll");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> displayRoll());
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

    private void displayRoll() {
        int roll = this.rollGenerator.roll(Integer.parseInt(this.diceNumber.getText()),
                Integer.parseInt(this.diceButtonGroup.getSelection().getActionCommand()));

        StringBuilder output = new StringBuilder();
        output.append(roll);
        output.append("\n");

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output.toString(), null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
