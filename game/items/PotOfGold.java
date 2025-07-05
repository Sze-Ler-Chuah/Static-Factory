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
 * This class represents a PotOfGold item in the game.
 * It implements the Consumable interface, meaning it can be consumed by an actor.
 * Created by:
 * @author Jack Lim
 * Modified by:
 * @author Yun Sion
 */
public class PotOfGold extends Item implements Consumable, Sellable {

    /**
     * Constructor of PotOfGold.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }

    /**
     * Consumes the pot of gold. The actor's balance is increased by 10.
     *
     * @param actor the actor that consumes the pot of gold
     * @return a string message indicating the result of the consumption
     */
    @Override
    public String consume(Actor actor) {
        actor.addBalance(10);   // Add 10 credits to the actor's balance
        actor.removeItemFromInventory(this); // Remove the pot of gold from the actor's inventory
        return actor + " took the gold out and gained 10 credits";
    }

    /**
     * Returns a string message indicating the function of the pot of gold.
     *
     * @param actor the actor that holds the pot of gold
     * @return a string message indicating the function of the pot of gold
     */
    @Override
    public String getItemFunction(Actor actor) {
        return actor + " takes the gold out of pot";
    }

    /**
     * Returns a list of allowable actions for the owner of the pot of gold.
     *
     * @param owner the actor that owns the pot of gold
     * @return a list of allowable actions for the owner
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Returns a list of allowable actions for the owner of the pot of gold does to other actor.
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
     * Sells the pot of gold and returns a string notifying the item being sold.
     *
     * @param actor the actor that sells the item
     * @return a string that represents the item being sold
     */
    @Override
    public String sell(Actor actor, GameMap gameMap) {
        int price = 500;
        if (Utility.getProbability(0.25)) {
            actor.removeItemFromInventory(this);
            return actor + "The factory took Pot of Gold making the intern cry with unfair compensation.";
        }
        actor.addBalance(price);
        actor.removeItemFromInventory(this);
        return actor + "successfully sold Pot of Gold for " + price + " credits.";
    }

    /**
     * Returns a string that represents the detail of the pot of gold being sold.
     *
     * @param actor the actor that sells the item being sold
     * @return a string that represents the detail of the item being sold
     */
    @Override
    public String getSellingItemDetail(Actor actor) {
        return actor + " sells Pot of Gold";
    }
}
