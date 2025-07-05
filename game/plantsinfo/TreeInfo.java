package game.plantsinfo;

import edu.monash.fit2099.engine.positions.Location;


/**
 * A class that represents a tree.
 * Created by:
 * Modified by: Sheng Jie
 */
public abstract class TreeInfo {

    /**
     * The character to display the tree.
     */
    private final char displayChar;

    /**
     * Constructor.
     *
     * @param displayChar the character that will represent the Tree on the map
     */
    public TreeInfo(char displayChar) {
        this.displayChar = displayChar;
    }

    /**
     * Ticks method on the Location object.
     *
     * @param location The location of the Ground
     */
    public void tick(Location location) {}

    /**
     * Returns the character to display the tree.
     *
     * @return the character to display the tree
     */
    public char getDisplayChar() {
        return displayChar;
    }

}
