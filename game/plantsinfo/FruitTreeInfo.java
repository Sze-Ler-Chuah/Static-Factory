package game.plantsinfo;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.factories.Factory;

/**
 * A class that represents the information of a tree that can drop fruit.
 * Created by:
 * @ author Sheng Jie
 */
public abstract class FruitTreeInfo extends TreeInfo {

    /**
     * The drop rate of the Item object.
     */
    private final double dropRate;

    /**
     * The ItemFactory that create item
     */
    private final Factory<Item> itemfactory;

    /**
     * Constructor.
     *
     * @param itemfactory the ItemFactory that creates the Item object
     * @param displayChar the character that will represent the Tree on the map
     * @param dropRate    the drop rate of the Item object
     */
    public FruitTreeInfo(char displayChar, double dropRate, Factory<Item> itemfactory) {
        super(displayChar);
        this.itemfactory = itemfactory;
        this.dropRate = dropRate;
    }

    /**
     * Ticks the Ground object by spawning the Item object into the game.
     * If our exits does not have a destination that blocks thrown objects, we will spawn the Item object.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {        // Randomly choose an exit
        int index = Utility.getRandIndex(location.getExits().size());

        if (Utility.getProbability(dropRate) && !location.getExits().get(index).getDestination().getGround().blocksThrownObjects()) {
            Location chosen = location.getExits().get(index).getDestination();
            chosen.addItem(itemfactory.createNew());
        }

    }
}
