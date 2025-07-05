package game.features;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface that represents the Consumable feature of an item in the game.
 * Created by:
 *
 * @author Sheng Jie
 */
public interface Purchasable {

    /**
     * Purchase the item and returns a string that about the message of item being purchased.
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the item being purchased
     */
    String purchase(Actor actor);

    /**
     * Returns a string that represents the detail of the item.
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the detail of the item
     */
    String getItemDetail(Actor actor);
}
