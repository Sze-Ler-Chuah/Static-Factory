package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.Ability;
import game.enums.Status;

import static game.FancyMessage.YOU_ARE_FIRED;

/**
 * Class representing the Player.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 * @author Sheng Jie, Sze Ler
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ENTER_FLOOR);
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        String info = super.name + "\n" +
                "(" +
                super.getAttribute(BaseActorAttributes.HEALTH) +
                "/" +
                super.getAttributeMaximum(BaseActorAttributes.HEALTH) +
                ")";
        display.println(info);
        String balance = "Balance: " + getBalance();
        display.println(balance);
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();
        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    /**
     * Returns the intrinsic weapon of the player.
     *
     * @return the intrinsic weapon of the player
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punch", 5);
    }

    /**
     * To print out a message to indicate player has met their demise
     *
     * @param actor the perpetrator
     * @param map   where the actor fell unconscious
     * @return the message to be displayed after the player met their demise
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        return this + " met their demise at the hand of " + actor + "\n\n" + YOU_ARE_FIRED;
    }
}
