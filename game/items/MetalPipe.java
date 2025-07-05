package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.enums.Ability;
import game.enums.Status;
import game.features.Sellable;

/**
 * A class that represents a Metal Pipe in the game.
 * Created by:
 * @author Sheng Jie
 * Modified by:
 * @author Yun Sion
 */
public class MetalPipe extends WeaponItem implements Sellable {

    /**
     * Constructor of MetalPipe.
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "attack", 20);
    }

    /**
     * Returns the allowable actions for the MetalPipe.
     *
     * @param otherActor the actor that is interacting with the MetalPipe
     * @param location   the location of the MetalPipe
     * @return a list of allowable actions for the MetalPipe
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(otherActor, location);
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            actions.add(new AttackAction(otherActor, "(" + location.x() + ", " + location.y() + ")", this));
        }
        if (otherActor.hasCapability(Ability.BUY_SCRAP)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    /**
     * Sells the metal pipe and returns a string notifying the item being sold.
     *
     * @param actor the actor that sells the item
     * @return a string that represents the item being sold
     */
    @Override
    public String sell(Actor actor, GameMap gamemap) {
        int price = 35;
        actor.addBalance(price);
        actor.removeItemFromInventory(this);
        return actor + "successfully sold Metal Pipe for " + price + " credits.";
    }

    /**
     * Returns a string that represents the detail of the metal pipe being sold.
     *
     * @param actor the actor that sells the item being sold
     * @return a string that represents the detail of the item being sold
     */
    @Override
    public String getSellingItemDetail(Actor actor) {
        return actor + " sells Metal Pipe";
    }
}