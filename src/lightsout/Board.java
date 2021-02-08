package lightsout;

import java.util.Random;

/**
 * A lights-out board.
 */
public class Board {

    /**
     * The size (width and height) of a board.
     */
    public static final int SIZE = 5;

    /**
     * All of the lights on the board.
     * <p>
     * There are {@code SIZE} rows of lights and {@code SIZE} lights in each row, and each light can be on or off.
     */
    private final boolean[][] lights = new boolean[SIZE][SIZE];

    /**
     * Constructs a new board with a random valid light pattern.
     */
    public Board() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            click(r.nextInt(5), r.nextInt(5));
    }

    /**
     * Checks whether the light on tile ({@code x}, {@code y}) is on.
     *
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     * @return {@code true} if tile ({@code x}, {@code y}) is on, {@code false} otherwise
     */
    public boolean isOn(int x, int y) {
        return lights[x][y];
    }

    /**
     * Performs a click on the tile at ({@code x}, {@code y}).
     * <p>
     * This toggles the tile and all it shares an edge with.
     *
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     */
    public void click(int x, int y) {
        toggle(x, y);
        toggle(x + 1, y);
        toggle(x - 1, y);
        toggle(x, y + 1);
        toggle(x, y - 1);
    }

    /**
     * Toggles the tile at ({@code x}, {@code y}).
     * <p>
     * This turns the tile on if it was off before, and turns it off if it was on before.
     *
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     */
    private void toggle(int x, int y) {
        if (0 <= x && x < 5)
            if (0 <= y && y < 5)
                lights[x][y] = !lights[x][y];
    }
}
