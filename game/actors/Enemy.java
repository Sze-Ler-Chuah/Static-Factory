package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.behaviours.WanderBehaviour;
import game.enums.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * An abstract class that represents an Enemy in the game.
 * Created by:
 *
 * @author Sheng Jie
 * Modified by:
 * @author Sze Ler
 */
public abstract class Enemy extends Actor {

    /**
     * Contstant variable to represent the priority of the wander behaviour with value 999.
     */
    private static final int WANDER_PRIORITY = 999;
    /**
     * A map of behaviours that the creature can perform
     */
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor.
     *
     * @param name        the name of this Creature
     * @param displayChar the character to use to represent this Creature in displays
     * @param hitPoints   the Creature's starting number of hitpoints
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.putBehaviour(WANDER_PRIORITY, new WanderBehaviour());
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
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The creature can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return an ActionList object representing the list of allowable actions for the other Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Add a behaviour to the creature
     *
     * @param priority  the priority of the behaviour
     * @param behaviour the behaviour to be added
     */
    public void putBehaviour(int priority, Behaviour behaviour) {
        this.behaviours.put(priority, behaviour);
    }

}
