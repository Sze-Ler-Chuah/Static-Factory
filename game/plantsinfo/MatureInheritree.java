package game.plantsinfo;

import game.items.LargeFruit;

/**
 * A class that represents a mature inheritree.
 * Created by:
 * Modified by: Sheng Jie
 */
public class MatureInheritree extends FruitTreeInfo {

    /**
     * Constructor of MatureInheritree.
     */
    public MatureInheritree() {
        super('T', 0.2, LargeFruit::new);
    }

}
