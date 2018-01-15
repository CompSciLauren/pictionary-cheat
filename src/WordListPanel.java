import javax.swing.*;
import java.awt.*;

public class WordListPanel extends JPanel {
    private String[] words;
    private JList wordJList;

    public WordListPanel() {
        this.setLayout(new BorderLayout());

        words = new String[0];
        JScrollPane scrollPane = new JScrollPane();

        wordJList = new JList();
        scrollPane.setViewportView(wordJList);

        this.add(scrollPane);
    }

    public void setWords(String[] words) {
        this.words = new String[words.length];
        for (int x = 0; x < words.length; x++) {
            this.words[x] = words[x];
        }

        wordJList.setListData(this.words);
    }
}
