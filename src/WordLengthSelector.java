import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordLengthSelector extends JPanel {
    private static final int[] numberOptions = {4, 5, 6, 7, 8, 9, 10, 11};

    private WordLengthSelectorListener listener;

    public WordLengthSelector() {
        this.setLayout(new BorderLayout());
        this.add(getJComboBox());
    }

    private JComboBox getJComboBox() {
        JComboBox comboBox = new JComboBox(getDisplayNames());
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedIndex() == 0) {
                    listener.onNumberOfLettersSelected(-1);
                    return;
                }

                int numberOfLetters = numberOptions[comboBox.getSelectedIndex() - 1];

                if (listener != null) {
                    listener.onNumberOfLettersSelected(numberOfLetters);
                }
            }
        });

        return comboBox;
    }

    void setListener(WordLengthSelectorListener listener) {
        this.listener = listener;
    }

    private static String[] getDisplayNames() {
        String[] optionDisplayNames = new String[numberOptions.length + 1];
        optionDisplayNames[0] = "--Select Number of Letters--";

        for (int x = 0 ; x < numberOptions.length; x++) {
            optionDisplayNames[x + 1] = numberOptions[x] + " Letters";
        }

        return optionDisplayNames;
    }
}
