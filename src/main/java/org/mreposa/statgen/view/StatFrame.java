package org.mreposa.statgen.view;

import org.mreposa.statgen.generator.StatGenerator;
import org.mreposa.statgen.model.adndclass.PlayerCharacterClass;
import org.mreposa.statgen.model.adndrace.PlayerCharacterRace;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.io.Serial;

public abstract class StatFrame extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final JMenuBar menuBar;
    private final ButtonGroup classButtonGroup;
    private final ButtonGroup raceButtonGroup;

    protected JPanel methodPanel;
    protected ButtonGroup methodButtonGroup;
    protected final JEditorPane displayArea;
    protected StatGenerator statGenerator;
    protected String selectedClass;
    protected String selectedRace;
    protected String selectedMethod = "NONE";

    public StatFrame() {
        super();

        JPanel basePanel;
        JPanel displayPanel;
        JPanel topPanel;
        JPanel buttonPanel;
        JButton generateButton;
        JButton clearButton;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                exitApp();
            }
        });

        this.menuBar = new JMenuBar();
        createFileMenu();
        createHelpMenu();
        this.setJMenuBar(this.menuBar);

        basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        basePanel.setSize(d);
        basePanel.setPreferredSize(d);
        add(basePanel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        generateButton = new JButton("Generate Stats");
        Dimension bd = new Dimension(145, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> generateStats());
        buttonPanel.add(generateButton);

        clearButton = new JButton("Clear");
        Dimension bd2 = new Dimension(90, 20);
        clearButton.setSize(bd2);
        clearButton.setPreferredSize(bd2);
        clearButton.setMaximumSize(bd2);
        clearButton.addActionListener(_ -> clearDisplay());
        buttonPanel.add(clearButton);

        displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        this.displayArea = new JEditorPane();
        this.displayArea.setSize(d);
        this.displayArea.setPreferredSize(d);
        displayPanel.add(this.displayArea);

        JPanel classPanel = new JPanel();
        classPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.classButtonGroup = new ButtonGroup();
        for (int a = 0; a < PlayerCharacterClass.AVAILABLE_CLASSES.length; a++) {
            JRadioButton btn = new JRadioButton();
            btn.setText(PlayerCharacterClass.AVAILABLE_CLASSES[a]);
            btn.setActionCommand(PlayerCharacterClass.AVAILABLE_CLASSES[a]);
            btn.addActionListener(this);
            this.classButtonGroup.add(btn);
            classPanel.add(btn);
            if (a == 0) {
                this.classButtonGroup.setSelected(btn.getModel(), true);
                this.selectedClass = PlayerCharacterClass.AVAILABLE_CLASSES[0];
            }
        }

        JPanel racePanel = new JPanel();
        racePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.raceButtonGroup = new ButtonGroup();
        for (int a = 0; a < PlayerCharacterRace.AVAILABLE_RACES.length; a++) {
            JRadioButton btn = new JRadioButton();
            btn.setText(PlayerCharacterRace.AVAILABLE_RACES[a]);
            btn.setActionCommand(PlayerCharacterRace.AVAILABLE_RACES[a]);
            btn.addActionListener(this);
            this.raceButtonGroup.add(btn);
            racePanel.add(btn);
            if (a == 0) {
                this.raceButtonGroup.setSelected(btn.getModel(), true);
                this.selectedRace = PlayerCharacterRace.AVAILABLE_RACES[0];
            }
        }

        this.methodPanel = new JPanel();
        this.methodPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.methodButtonGroup = new ButtonGroup();

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4, 1));
        topPanel.add(racePanel);
        topPanel.add(classPanel);
        topPanel.add(this.methodPanel);
        topPanel.add(buttonPanel);

        basePanel.add(topPanel, BorderLayout.NORTH);
        basePanel.add(displayPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e != null) {
            this.selectedClass = classButtonGroup.getSelection().getActionCommand();
            this.selectedRace = raceButtonGroup.getSelection().getActionCommand();
            this.selectedMethod = methodButtonGroup.getSelection().getActionCommand();
        }
    }

    private void generateStats() {
        int[] stats = statGenerator.generate(this.selectedClass, this.selectedRace, this.selectedMethod);

        String displayStats = getDisplayStats(stats);

        try {
            Document doc = this.displayArea.getDocument();
            doc.insertString(doc.getLength(), displayStats, null);
        } catch (BadLocationException ble) {
            this.displayArea.setText("ERROR: " + ble.getMessage());
        }
    }

    public abstract String getDisplayStats(int[] stats);
    public abstract String getAbout();

    private void clearDisplay() {
        this.displayArea.setText("");
    }

    /*
     * Shut down the application
     */
    private void exitApp() {
        this.dispose();
        System.exit(0);
    }

    private void createFileMenu() {
        JMenu menu = new JMenu("File");
        this.menuBar.add(menu);

        // File -> Exit
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
        exitMenuItem.addActionListener(_ -> exitApp());
        menu.add(exitMenuItem);
    }

    private void createHelpMenu() {
        JMenu menu = new JMenu("Help");
        this.menuBar.add(menu);

        // Help -> About...
        JMenuItem menuItem = new JMenuItem("About...");
        menuItem.addActionListener(_ -> showAbout());
        menu.add(menuItem);
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this, getAbout(), "About", JOptionPane.PLAIN_MESSAGE);
    }
}
