package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.features.Sellable;

/**
 * Action that allows an actor to sell a sellable item.
 * created by
 * @author Yun Sion
 */
public class SellAction extends Action {
    /**
     * The sellable item to be sold.
     */
    private Sellable sellableItem;

    /**
     * Constructor of SellAction
     * @param sellableItem The sellable item to be sold
     */
    public SellAction(Sellable sellableItem){this.sellableItem = sellableItem;}

    /**
     * Execute the Selling Action on a sellable item.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The string describing the result of the selling action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return sellableItem.sell(actor, map);
    }

    /**
     * Returns a string describing the selling action.
     * @param actor The actor performing the action.
     * @return The string describing the selling action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return sellableItem.getSellingItemDetail(actor);
    }
}
