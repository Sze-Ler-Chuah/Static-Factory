package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.features.Consumable;

/**
 * An abstract class that represents a health booster item in the game.
 * Created by:
 *
 * @author Sheng Jie
 */
public abstract class HealthBooster extends Item implements Consumable {

    /**
     * Heal point of the health booster
     */
    private final int healPoint;

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param portable    whether the item is portable
     * @param healPoint   heal point of the health booster
     */
    public HealthBooster(String name, char displayChar, boolean portable, int healPoint) {
        super(name, displayChar, portable);
        this.healPoint = healPoint;
    }

    /**
     * Create a list of allowable actions for the actor to perform when the actor is carrying this item.
     *
     * @param owner the actor carrying this item
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * The effect of consuming the item.
     *
     * @param actor the actor that consumes the item
     * @return a string that represents message of the item being consumed
     */
    @Override
    public String consume(Actor actor) {
        actor.heal(healPoint);
        actor.removeItemFromInventory(this);
        return actor + " consume " + this + " to heal " + healPoint + " HP ";
    }

    /**
     * Returns a string that represents the function of the item.
     *
     * @param actor the actor that uses the item
     * @return a string that represents the function of the item
     */
    @Override
    public String getItemFunction(Actor actor) {
        return actor + " consume " + this + " to heal " + healPoint + " HP";
    }
}
