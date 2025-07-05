package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.enums.Ability;
import game.features.Sellable;

/**
 * A class that represents a LargeFruit.
 * Created by:
 * @author Sheng Jie
 * Modified by:
 * @author Yun Sion
 */
public class LargeFruit extends HealthBooster implements Sellable {

    /**
     * Constructor of LargeFruit.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true, 2);
    }

    /**
     * Returns a list of allowable actions for the owner of the large fruit does to other actor.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of allowable actions for the owner
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = super.allowableActions(otherActor, location);
        if (otherActor.hasCapability(Ability.BUY_SCRAP)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Sells the large fruit and returns a string notifying the item being sold.
     *
     * @param actor the actor that sells the item
     * @return a string that represents the item being sold
     */
    @Override
    public String sell(Actor actor, GameMap gamemap) {
        int price = 30;
        actor.addBalance(price);
        actor.removeItemFromInventory(this);
        return actor + "successfully sold Large Fruit for " + price + " credits.";
    }

    /**
     * Returns a string that represents the detail of the large fruit being sold.
     *
     * @param actor the actor that sells the item being sold
     * @return a string that represents the detail of the item being sold
     */
    @Override
    public String getSellingItemDetail(Actor actor) {
        return actor + " sells Large Fruit";
    }
}
