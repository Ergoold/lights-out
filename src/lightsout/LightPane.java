package lightsout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A pane containing a lights out game.
 */
public class LightPane extends JPanel {

    /**
     * The size of each tile, in pixels.
     */
    private static final int SIZE = 50;

    /**
     * The color that tiles that are on are filled with.
     */
    private static final Color ON_COLOR = Color.YELLOW;

    /**
     * The color that tiles that are off are filled with.
     */
    private static final Color OFF_COLOR = Color.GRAY;

    /**
     * The color of the border between tiles.
     */
    private static final Color BORDER_COLOR = Color.BLACK;

    /**
     * The lights out game board displayed on this pane.
     */
    private Board board = new Board();

    public LightPane() {
        setPreferredSize(new Dimension(SIZE * Board.SIZE, SIZE * Board.SIZE));
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                board.click(e.getX() / SIZE, e.getY() / SIZE);
                repaint();
                if (board.isClear()) {
                    int option = JOptionPane.showConfirmDialog(LightPane.this,
                            "You Win! Play Again?", "WinError",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (option == JOptionPane.CANCEL_OPTION) System.exit(0);
                    board = new Board();
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < Board.SIZE; i++)       // rows (y)
            for (int j = 0; j < Board.SIZE; j++) { // cols (x)
                g.setColor(board.isOn(j, i) ? ON_COLOR : OFF_COLOR);
                g.fillRect(j * SIZE, i * SIZE, SIZE, SIZE);
                g.setColor(BORDER_COLOR);
                g.drawRect(j * SIZE, i * SIZE, SIZE, SIZE);
            }
    }
}
