package game.managers;

import game.plantsinfo.*;

import java.util.List;

/**
 * A class that manages the creation of LifeManager objects.
 * Created by:
 * Modified by: Sheng Jie
 */
public class TreeManager {

    /**
     * Returns a LifeManager object that manages the life of a tree in Polymorphia.
     *
     * @return A LifeManager object that manages the life of a tree in Polymorphia.
     */
    public static LifeManager getPolymorphiaManager(){
        final int PERIOD = 5;
        LifeManager treeLifeManager= new LifeManager(List.of(PERIOD));
        TreeInfo tree = new Sapling();
        treeLifeManager.addTree(tree);
        tree = new MatureInheritree();
        treeLifeManager.addTree(tree);
        return treeLifeManager;
    }

    /**
     * Returns a LifeManager object that manages the life of a tree in Refactoria.
     *
     * @return A LifeManager object that manages the life of a tree in Refactoria.
     */
    public static LifeManager getRefactoriaManager(){
        final int PERIOD_1 = 3;
        final int PERIOD_2 = 9;
        final int PERIOD_3 = 14;
        LifeManager treeLifeManager= new LifeManager(List.of(PERIOD_1, PERIOD_2, PERIOD_3));
        TreeInfo tree = new Sprout();
        treeLifeManager.addTree(tree);
        tree = new Sapling();
        treeLifeManager.addTree(tree);
        tree = new YoungInheritree();
        treeLifeManager.addTree(tree);
        tree = new MatureInheritree();
        treeLifeManager.addTree(tree);
        return treeLifeManager;
    }
}
