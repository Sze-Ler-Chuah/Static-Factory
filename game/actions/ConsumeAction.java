package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.features.Consumable;

/**
 * Action that allows an actor to consume a consumable item.
 * created by
 *
 * @author Sheng Jie
 */
public class ConsumeAction extends Action {

    /**
     * The consumable item to be consumed.
     */
    private Consumable consumableItem;

    /**
     * Constructor.
     *
     * @param consumableItem the consumable item to be consumed
     */
    public ConsumeAction(Consumable consumableItem) {
        this.consumableItem = consumableItem;
    }

    /**
     * Executes the action of consuming the consumable item.
     *
     * @param actor the actor performing the action
     * @param map   the map where the action is being performed
     * @return a string describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumableItem.consume(actor);
    }

    /**
     * Returns a string describing the action of consuming the consumable item.
     *
     * @param actor the actor performing the action
     * @return a string describing the action of consuming the consumable item
     */
    @Override
    public String menuDescription(Actor actor) {
        return consumableItem.getItemFunction(actor);
    }

}
