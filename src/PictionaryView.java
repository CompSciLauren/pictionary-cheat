import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PictionaryView {
    private JPanel viewPanel = new JPanel();
    private String[] words;

    public PictionaryView(Container container) {
        words = WordInput.words;
        container.add(viewPanel);
        viewPanel.setLayout(new BorderLayout());

        addUIToViewPanel();
    }

    private void addUIToViewPanel() {
        WordLengthSelector wordLengthSelector = new WordLengthSelector();
        WordListPanel wordList = new WordListPanel();
        wordList.setWords(words);
        wordLengthSelector.setListener(new WordLengthSelectorListener() {
            @Override
            public void onNumberOfLettersSelected(int numberOfLettersSelected) {
                if (numberOfLettersSelected == -1) {
                    wordList.setWords(words);
                    return;
                }

                String[] filteredWords = getWordsOfLength(numberOfLettersSelected);
                wordList.setWords(filteredWords);
            }
        });

        viewPanel.add(wordLengthSelector, BorderLayout.PAGE_START);
        viewPanel.add(wordList, BorderLayout.LINE_END);
    }

    private String[] getWordsOfLength(int length) {
        ArrayList<String> listOfWords = new ArrayList<>();
        for(int x = 0; x < words.length; x++) {
            if(words[x].length() == length) {
                listOfWords.add(words[x]);
            }
        }
        String[] listOfWordsArray = listOfWords.toArray(new String[listOfWords.size()]);
        return listOfWordsArray;
    }
}
