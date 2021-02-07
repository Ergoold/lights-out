package lightsout;

import javax.swing.*;

/**
 * A frame that contains a lights out game.
 */
public class Gui extends JFrame {

    private Gui() {
        setTitle("Lights Out");
        setContentPane(new LightPane());
        pack();
        setResizable(false);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
