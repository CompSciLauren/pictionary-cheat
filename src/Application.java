import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        //Use an appropriate Look and Feel
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window
        JFrame frame = new JFrame("Pictionary Cheat");
        frame.setPreferredSize(new Dimension(350, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container mainContainer = frame.getContentPane();
        PictionaryView view = new PictionaryView(mainContainer);

        //Display the window
        frame.pack();
        frame.setVisible(true);
    }
}
