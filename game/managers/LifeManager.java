package game.managers;

import edu.monash.fit2099.engine.positions.Location;
import game.plantsinfo.TreeInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that manages the life of a tree.
 * Created by:
 * Modified by: Sheng Jie
 */

public class LifeManager {

    /**
     * A list of TreeInfo objects that represent the different stages of the tree.
     */
    private final List <TreeInfo> trees = new ArrayList<>();

    /**
     * The age of the tree.
     */
    private int age = 0;

    /**
     * The current stage of the tree.
     */
    private  int currentStage = 0;

    /**
     * A list of integers that represent time to grow to the next stage.
     */
    private final List<Integer> stages;

    /**
     * Constructor.
     *
     * @param stages A list of integers that represent time to grow to the next stage.
     */
    public LifeManager(List<Integer> stages) {
        this.stages = stages;
    }

    /**
     * Adds a TreeInfo object to the list of trees.
     *
     * @param tree A TreeInfo object that represents a stage of the tree.
     */
    public void addTree(TreeInfo tree) {
        trees.add(tree);
    }

    /**
     * Updates the tree's age and stage.
     *
     * @param location The location of the tree.
     */
    public void tick(Location location) {
        age++;
        if (currentStage < stages.size() && age == stages.get(currentStage)) {
            increaseStage();
            }
        TreeInfo tree = trees.get(currentStage);
        tree.tick(location);
    }

    /**
     * Gets the display character of the tree.
     *
     * @return the display character of the tree.
     */
    public char getDisplayChar() {
        TreeInfo tree = trees.get(currentStage);
        return tree.getDisplayChar();
    }

    /**
     * Increases the stage of the tree.
     */
    private void increaseStage() {
        currentStage++;
    }
}
