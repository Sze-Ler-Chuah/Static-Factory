package game.grounds;

import game.managers.TreeManager;

/**
 * A class that represents a tree.
 * Created by:
 * Modified by: Sheng Jie
 */

public class PolymorphiaTree extends Tree{
    /**
     * Constructor for RefactoriaTree.
     */
    public PolymorphiaTree(){
        super(TreeManager.getPolymorphiaManager());
    }
}
