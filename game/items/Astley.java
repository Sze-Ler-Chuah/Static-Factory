package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actions.ListenAction;
import game.features.Monologueble;
import game.features.Purchasable;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents item Astley in the game.
 * Created by:
 * @Author Sze Ler
 */
public class Astley extends Item implements Purchasable, Monologueble {
    /**
     * The price of purchasing Astley.
     */
    private static final int price = 50;
    /**
     * The subscription fee of Astley.
     */
    private static final int subscriptionFee = 1;
    /**
     * counter for rounds.
     */
    private int count = 1;
    /**
     * The round for subscription.
     */
    private static final int Subscriptionround = 5;
    /**
     * A boolean to check if actor can listen to Astley's monologue.
     */
    private boolean canListen = true;
    /**
     * Constructor for Astley.
     */
    public Astley() {
        super("Astley", 'z', true);
    }

    /**
     * Method for actor to purchase Astley.
     * @param actor the actor that purchases the item
     * @return a string that represents the result of the purchase
     */
    @Override
    public String purchase(Actor actor) {
        if (actor.getBalance() >= price) {
            actor.deductBalance(price);
            actor.addItemToInventory(this);
            return actor + " successfully purchased Astley for " + price + " credits.";
        }
        return actor + "'s credits is insufficient to purchase Astley.";
    }

    /**
     * To check if actor need to pay subscription fee for Astley and if actor can continue to listen to Astley's monologue.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor){
        Display display = new Display();
        count ++;
        if (count % Subscriptionround == 0){
            boolean canSubscribe = actor.getBalance() >= subscriptionFee;
            if (canSubscribe){
                display.println(actor + " has been charged " + subscriptionFee + " credits for Astley subscription.");
                actor.deductBalance(subscriptionFee);
                canListen = true;
            }
            else{
                display.println(actor + " has insufficient credits to pay for Astley subscription.");
                canListen = false;
            }
        }
    }

    /**
     * Show at the terminal what is being purchased
     * @param actor the actor that purchases the item
     * @return a string that represents the object being purchased
     */
    @Override
    public String getItemDetail(Actor actor) {
        return actor + " purchase Astley";
    }

    /**
     * Returns the allowable actions for the actor with Astley.
     * @param owner the actor that owns the item
     * @return a list of allowable actions for the actor
     */
    @Override
    public ActionList allowableActions(Actor owner){
        if (canListen){
            return new ActionList(new ListenAction(this));
        }
        return super.allowableActions(owner);
    }
    /**
     * Use to put all the monologues that Astley can say and return a random monologue.
     * @param actor the actor that listens to the monologue
     * @return a string that represents the monologue
     */
    @Override
    public String listenMonologue(Actor actor){
        List<String> monologues = new ArrayList<>();
        monologues.add("The factory will never gonna give you up, valuable intern!");
        monologues.add("We promise we never gonna let you down with a range of staff benefits.");
        monologues.add("We never gonna run around and desert you, dear intern!");
        if (actor.getItemInventory().size() > 10){
            monologues.add("We never gonna make you cry with unfair compensation.");
        }
        if (actor.getBalance() > 50){
            monologues.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
        }
        if (actor.getAttribute(BaseActorAttributes.HEALTH) < 2){
            monologues.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }
        return monologues.get(Utility.getRandIndex(monologues.size()));
    }
    /**
     * Show at the menu what can be done with Astley.
     * @param actor the actor that purchases the item
     * @return a string that represents the function of the item
     */

    @Override
    public String getItemFunction(Actor actor) {
        return actor + " listens to Astley's monologue.";
    }

}
