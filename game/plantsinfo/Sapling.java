package game.plantsinfo;

import game.items.SmallFruit;

/**
 * A class that represents a sapling.
 * Created by:
 * Modified by: Sheng Jie
 */
public class Sapling extends FruitTreeInfo {

    /**
     * Constructor of Sapling.
     */
    public Sapling() {
        super('t', 0.3, SmallFruit::new);
    }

}
