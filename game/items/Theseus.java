package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TravelAction;
import game.features.Purchasable;

/**
 * The Theseus class represents a specific item in the game.
 * This item, when purchased by an actor, allows the actor to teleport to a random location on the map.
 * The teleportation action is only successful if the destination is not blocked by a wall or tree.
 * The Theseus item can be purchased if the actor has sufficient credits.
 * The price of the Theseus item is set to 100 credits.
 * This class implements the Purchasable interface, which provides methods for purchasing items.
 * Created by:
 * @author Jie Yang
 */
public class Theseus extends Item implements Purchasable {
    /**
     * The price of the item.
     */
    private final int price = 100;

    /**
     * Constructor.
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    /**
     * Purchase the item and returns a string that about the message of item being purchased.
     *
     * @param actor The actor who is purchasing the item.
     * @return the string that represents the item being purchased or not
     */
    @Override
    public String purchase(Actor actor) {
        if (actor.getBalance() >= price) {
            actor.deductBalance(price);
            actor.addItemToInventory(this);
            return actor + " successfully purchased THESEUS for " + price + " credits.";
        }
        return actor + "'s credits is insufficient to purchase THESEUS.";
    }

    /**
     * Returns the message to purchase the item.
     *
     * @param actor The actor who is purchasing the item.
     * @return the message to purchase the item
     */
    @Override
    public String getItemDetail(Actor actor) {
        return actor + " purchase THESEUS";
    }


    /**
     * Returns the action list of the item.
     * The action list includes a MoveActorAction to a random position on the map that is not blocked by a wall or tree.
     *
     * @param location The current location of the actor.
     * @return the action list of the item
     */
    @Override
    public ActionList allowableActions(Location location) {

        // Create a new action list
        ActionList actions = super.allowableActions(location);

        actions.add(new TravelAction());

        // Return the list of actions
        return actions;
    }

}
