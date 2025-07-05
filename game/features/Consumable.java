package game.features;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface that represents the Consumable feature of an item in the game.
 * Created by:
 *
 * @author Sheng Jie
 */
public interface Consumable {

    /**
     * Consume the item and returns a string that about the message of item being consumed.
     *
     * @param actor the actor that consumes the item
     * @return a string that represents the item being consumed
     */
    String consume(Actor actor);

    /**
     * Returns a string that represents the function of the item.
     *
     * @param actor the actor that uses the item
     * @return a string that represents the function of the item
     */
    String getItemFunction(Actor actor);

}
