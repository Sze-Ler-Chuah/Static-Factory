package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.features.Purchasable;

/**
 * Action that allows an actor to purchase a purchasable item.
 * created by
 *
 * @author Sheng Jie
 */
public class PurchaseAction extends Action {

    /**
     * The purchasable item to be purchased.
     */
    private Purchasable purchasableItem;

    /**
     * Constructor.
     *
     * @param purchasableItem the purchasable item to be purchased
     */
    public PurchaseAction(Purchasable purchasableItem) {
        this.purchasableItem = purchasableItem;
    }

    /**
     * Executes the action of purchasing the purchasable item.
     *
     * @param actor the actor performing the action
     * @param map   the map where the action is being performed
     * @return a string describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return purchasableItem.purchase(actor);
    }

    /**
     * Returns a string describing the action of consuming the consumable item.
     *
     * @param actor the actor performing the action
     * @return a string describing the action of consuming the consumable item
     */
    @Override
    public String menuDescription(Actor actor) {
        return purchasableItem.getItemDetail(actor);
    }
}
