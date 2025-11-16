package org.mreposa.statgen;

import org.mreposa.statgen.view.adnd.AdndStatFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AdndStatFrame::new);
    }
}