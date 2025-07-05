package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Utility;
import game.actions.AttackAction;
import game.enums.Status;
import game.features.Purchasable;

/**
 * A class that represents a Dragon Slayer Sword in the game.
 * Created by:
 *
 * @author Sheng Jie
 */
public class DragonSlayerSword extends WeaponItem implements Purchasable {

    /**
     * The price of the Dragon Slayer Sword.
     */
    private final int price = 100;

    /**
     * Constructor of Dragon Slayer Sword.
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slashes", 75);
    }

    /**
     * Returns the allowable actions for the actor in the location.
     *
     * @param otherActor the actor that is on the location
     * @param location   the location that the actor is on
     * @return a list of allowable actions for the actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            return new ActionList(new AttackAction(otherActor, "(" + location.x() + ", " + location.y() + ")", this));
        }
        return super.allowableActions(otherActor, location);
    }

    /**
     * The method for actor to purchase the Dragon Slayer Sword.
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the result of the purchase
     */
    @Override
    public String purchase(Actor actor) {
        if (actor.getBalance() >= price) {
            actor.deductBalance(price);
        } else {
            return actor + "'s credits is insufficient to purchase Dragon Slayer Sword.";
        }

        if (Utility.getProbability(0.5)) {
            actor.addItemToInventory(this);
            return actor + "successfully purchased Dragon Slayer Sword for " + price + " credits.";
        } else {
            return price + " credits are taken from " + actor + ", but " + actor + " doesn't receive anything in return!";
        }
    }

    /**
     * Show at the terminal what is being purchased
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the object being purchased
     */
    @Override
    public String getItemDetail(Actor actor) {
        return actor + " purchase Dragon Slayer Sword";
    }
}
