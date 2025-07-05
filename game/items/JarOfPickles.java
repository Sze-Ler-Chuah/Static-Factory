package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.enums.Ability;
import game.features.Consumable;
import game.features.Sellable;

/**
 * This class represents a JarOfPickles item in the game.
 * It implements the Consumable interface, meaning it can be consumed by an actor.
 * Created by :
 *
 * @author Jack Lim
 * Modified by:
 * @author Jack Lim, Sheng Jie, Yun Sion
 */
public class JarOfPickles extends Item implements Consumable, Sellable {
    /**
     * Constructor of JarOfPickles.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
    }

    /**
     * Consumes the jar of pickles. If the jar is fresh, it adds 1 health point to the actor.
     * If the jar is expired, it deducts 1 health point from the actor.
     *
     * @param actor the actor that consumes the jar of pickles
     * @return a string message indicating the result of the consumption
     */
    @Override
    public String consume(Actor actor) {
        // If the jar of pickles is fresh, add 1 health point to the actor
        if (Utility.getProbability(0.5)) {
            actor.heal(1);
            actor.removeItemFromInventory(this);
            return actor + " has consumed a fresh Jar of Pickles and gained 1 health point";
        }
        // If the jar of pickles is expired, deduct 1 health point from the actor
        else {
            actor.hurt(1);
            actor.removeItemFromInventory(this);
            return actor + " has consumed an expired Jar of Pickles and lost 1 health point";
        }
    }

    /**
     * Returns a string message indicating the function of the jar of pickles.
     *
     * @param actor the actor that holds the jar of pickles
     * @return a string message indicating the function of the jar of pickles
     */
    @Override
    public String getItemFunction(Actor actor) {
        return actor + " consumes Jar of Pickles";
    }

    /**
     * Returns a list of allowable actions for the owner of the jar of pickles.
     *
     * @param owner the actor that owns the jar of pickles
     * @return a list of allowable actions for the owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Returns a list of allowable actions for the owner of the jar of pickles does to other actor.
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
     * Sells the jar of pickles and returns a string notifying the item being sold.
     *
     * @param actor the actor that sells the item
     * @return a string that represents the item being sold
     */
    @Override
    public String sell(Actor actor, GameMap gamemap) {
        int price = 25;
        if (Utility.getProbability(0.60)) {
            actor.addBalance(50);
            actor.removeItemFromInventory(this);
            return actor + "successfully sold Jar of Pickles for a doubled price (" + price + " credits).";
        }
        actor.addBalance(price);
        actor.removeItemFromInventory(this);
        return actor + "successfully sold Jar of Pickles for " + price + " credits.";
    }

    /**
     * Returns a string that represents the detail of the jar of pickles being sold.
     *
     * @param actor the actor that sells the item being sold
     * @return a string that represents the detail of the item being sold
     */
    @Override
    public String getSellingItemDetail(Actor actor) {
        return actor + " sells Jar of Pickles";
    }
}
