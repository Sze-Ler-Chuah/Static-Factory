package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.Utility;
import game.features.Purchasable;

/**
 * A class that represents an Energy Drink in the game.
 * Created by:
 *
 * @author Sheng Jie
 */
public class EnergyDrink extends HealthBooster implements Purchasable {

    /**
     * The price of the Energy Drink.
     */
    private final int price = 10;

    /**
     * Constructor of Energy Drink.
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true, 1);
    }

    /**
     * The method for actor to purchase the Energy Drink.
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the result of the purchase
     */
    @Override
    public String purchase(Actor actor) {
        int cost = price;
        if (Utility.getProbability(0.2)) {
            cost = price * 2;
        }
        if (actor.getBalance() >= cost) {
            actor.deductBalance(cost);
            actor.addItemToInventory(this);
            return actor + " successfully purchased Energy Drink for " + cost + " credits.";
        }
        return actor + "'s credits is insufficient to purchase Energy Drink.";
    }

    /**
     * Show at the terminal what is being purchased
     *
     * @param actor the actor that purchases the item
     * @return a string that represents the object being purchased
     */
    @Override
    public String getItemDetail(Actor actor) {
        return actor + " purchase Energy Drink";
    }

}
