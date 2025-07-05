package game.grounds;

import game.managers.TreeManager;

/**
 * A class that represents a tree.
 * Created by:
 *
 * @author Sheng Jie
 */

public class RefactorioTree extends Tree {

    /**
     * Constructor for RefactoriaTree.
     */
    public RefactorioTree(){
        super(TreeManager.getRefactoriaManager());
    }

}
