package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.managers.LifeManager;

/**
 * A class that represents a tree in the game.
 * Created by:
 * Riordan D. Alfredo
 * Sheng Jie
 */

public abstract class Tree extends Ground {

    /**
     * Constructor for Tree.
     *
     * @param lifeManager The life manager of the tree.
     */
    private final LifeManager lifeManager;

    /**
     * Constructor for Tree.
     *
     * @param lifeManager The life manager of the tree.
     */
    public Tree(LifeManager lifeManager) {
        super(',');
        this.lifeManager = lifeManager;
    }

    /**
     * Tick method for the tree.
     *
     * @param location The location of the tree.
     */
    @Override
    public void tick(Location location) {
        super.setDisplayChar(lifeManager.getDisplayChar());
        lifeManager.tick(location);
    }

}
