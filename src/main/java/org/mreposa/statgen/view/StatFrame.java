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

public abstract class StatFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final JMenuBar menuBar;

    private final JComboBox<String> charClass;
    private final JComboBox<String> charRace;

    protected JPanel methodPanel;
    protected ButtonGroup methodButtonGroup;
    protected final JEditorPane displayArea;
    protected StatGenerator statGenerator;
    protected String selectedClass;
    protected String selectedRace;
    protected String selectedMethod = "NONE";

    private JFrame functionFrame;

    public StatFrame() {
        super();

        JPanel basePanel;
        JPanel classPanel;
        JPanel displayPanel;
        JPanel topPanel;
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
        createToolsMenu();
        createHelpMenu();
        setJMenuBar(this.menuBar);

        basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        basePanel.setSize(d);
        basePanel.setPreferredSize(d);
        add(basePanel);

        classPanel = new JPanel();
        classPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label1 = new JLabel("Class:");
        classPanel.add(label1);

        this.charClass = new JComboBox<>(PlayerCharacterClass.AVAILABLE_CLASSES);
        this.charClass.setSelectedIndex(0);
        classPanel.add(this.charClass);

        JLabel label2 = new JLabel("Race:");
        classPanel.add(label2);

        this.charRace = new JComboBox<>(PlayerCharacterRace.AVAILABLE_RACES);
        this.charRace.setSelectedIndex(0);
        classPanel.add(this.charRace);

        generateButton = new JButton("Generate Stats");
        Dimension bd = new Dimension(145, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> generateStats());
        classPanel.add(generateButton);

        clearButton = new JButton("Clear");
        Dimension bd2 = new Dimension(90, 20);
        clearButton.setSize(bd2);
        clearButton.setPreferredSize(bd2);
        clearButton.setMaximumSize(bd2);
        clearButton.addActionListener(_ -> clearDisplay());
        classPanel.add(clearButton);

        this.methodPanel = new JPanel();
        this.methodPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label3 = new JLabel("Rolling Method:");
        this.methodPanel.add(label3);
        this.methodButtonGroup = new ButtonGroup();

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        topPanel.add(classPanel);
        topPanel.add(this.methodPanel);

        displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());

        this.displayArea = new JEditorPane();
        this.displayArea.setSize(d);
        this.displayArea.setPreferredSize(d);
        displayPanel.add(this.displayArea);

        basePanel.add(topPanel, BorderLayout.NORTH);
        basePanel.add(displayPanel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

     private void generateStats() {
        this.selectedClass = (String)this.charClass.getSelectedItem();
        this.selectedRace = (String)this.charRace.getSelectedItem();
        this.selectedMethod = this.methodButtonGroup.getSelection().getActionCommand();

        int[] stats = this.statGenerator.generate(this.selectedClass, this.selectedRace, this.selectedMethod);

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
        if (this.functionFrame != null) {
            this.functionFrame.dispose();
        }
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

    private void createToolsMenu() {
        JMenu menu = new JMenu("Tools");
        this.menuBar.add(menu);

        // Tools -> Thief Functions
        JMenuItem functionsMenuItem = new JMenuItem("Thief Functions");
        functionsMenuItem.setAccelerator(KeyStroke.getKeyStroke('T', InputEvent.CTRL_DOWN_MASK));
        functionsMenuItem.addActionListener(_ -> showThiefFunctions());
        menu.add(functionsMenuItem);
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

    private void showThiefFunctions() {
        if (this.functionFrame == null) {
            this.functionFrame = new ThiefFunctionFrame();
        }
        else {
            this.functionFrame.setVisible(true);
        }
    }
}
