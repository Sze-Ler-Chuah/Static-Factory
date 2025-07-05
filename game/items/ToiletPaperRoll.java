package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actions.SellAction;
import game.enums.Ability;
import game.features.Purchasable;
import game.features.Sellable;

import static game.FancyMessage.YOU_ARE_FIRED;

/**
 * A class that represents a Toilet Paper Roll in the game.
 * Created by:
 * @author Sheng Jie
 * Modified by:
 * @author Yun Sion
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellable {

    /**
     * The price of the Toilet Paper Roll.
     */
    private final int price = 5;

    /**
     * Constructor of Toilet Paper Roll.
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    /**
     * The method for actor to purchase the Toilet Paper Roll.
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the result of the purchase
     */
    @Override
    public String purchase(Actor actor){
        int cost = price;
        if (Utility.getProbability(0.75)) {
            cost = 1;
        }
        if (actor.getBalance() >= cost) {
            actor.deductBalance(cost);
            actor.addItemToInventory(this);
            return actor + "successfully purchased Toilet Paper Roll for " + cost + " credits.";
        }
        return actor + "'s credits is insufficient to purchase Toilet Paper Roll.";
    }

    /**
     * Show at the terminal what is being purchased
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the object being purchased
     */
    @Override
    public String getItemDetail(Actor actor) {
        return actor + " purchase Toilet Paper Roll";
    }

    /**
     * Returns a list of allowable actions for the owner of the toilet paper roll does to other actor.
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
     * Sells the toilet paper roll and returns a string notifying the item being sold.
     *
     * @param actor the actor that sells the item
     * @return a string that represents the item being sold
     */
    @Override
    public String sell(Actor actor, GameMap gamemap) {
        int price = 1;
        if (Utility.getProbability(0.50)) {
            actor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE, 0);
            actor.unconscious(gamemap);
            return actor + " ceased to exist by selling (s)crap to the Humanoid Figure\n\n" + YOU_ARE_FIRED;
        }
        actor.addBalance(price);
        actor.removeItemFromInventory(this);
        return actor + "successfully sold Toilet Paper Roll for " + price + " credits.";
    }

    /**
     * Returns a string that represents the detail of the toilet paper roll being sold.
     *
     * @param actor the actor that sells the item being sold
     * @return a string that represents the detail of the item being sold
     */
    @Override
    public String getSellingItemDetail(Actor actor) {
        return actor + " sells Toilet Paper Roll";
    }
}
