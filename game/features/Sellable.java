package game.features;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An interface that represents the Sellable feature of an item in the game.
 * Created by:
 * @author Yun Sion
 */
public interface Sellable {
    /**
     * Sells the item and returns a string notifying the item being sold.
     *
     * @param actor the actor that sells the item
     * @return a string that represents the item being sold
     */
    String sell(Actor actor, GameMap gamemap);

    /**
     * Returns a string that represents the detail of the item being sold.
     *
     * @param actor the actor that sells the item being sold
     * @return a string that represents the detail of the item being sold
     */
    String getSellingItemDetail(Actor actor);
}
