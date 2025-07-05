package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickBehaviour;
import game.enums.Ability;
import game.enums.Status;
import game.features.Follower;

import java.util.List;

/**
 * A class that represents an AlienBug in the game.
 * AlienBug extends from Enemy class.
 * Created by :
 *
 * @author Sze Ler, Yun Sion
 */
public class AlienBug extends Enemy implements Follower {
    /**
     * Constant variable representing the priority of the PickBehaviour of AlienBug.
     */
    private static final int PICK_PRIORITY = 0;
    /**
     * Constant variable representing the priority of the FollowBehaviour of AlienBug.
     */
    private static final int FOLLOW_PRIORITY = 1;
    /**
     * The targetActor that AlienBug will follow.
     */
    private Actor targetActor;

    /**
     * Constructor for AlienBug.
     * Add 2 behaviours to AlienBug, PickBehaviour and FollowBehaviour.
     * Add ENTER_FLOOR capability to AlienBug to allow AlienBug to enter the floor of SpaceShip.
     */
    public AlienBug() {
        super("Feature-" + Utility.getRandInt(), 'a', 2);
        this.putBehaviour(PICK_PRIORITY, new PickBehaviour());
        this.putBehaviour(FOLLOW_PRIORITY, new FollowBehaviour(this));
        this.addCapability(Ability.ENTER_FLOOR);
    }

    /**
     * playTurn to check if the AlienBug has a targetActor to follow.
     * If the targetActor is not in the map, set the targetActor to null.
     * If the targetActor is null, find the targetActor in the map.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.targetActor != null && !map.contains(this.targetActor)) {
            this.targetActor = null;
        }
        if (this.targetActor == null) {
            List<Exit> exits = map.locationOf(this).getExits();
            for (Exit exit : exits) {
                if (exit.getDestination().containsAnActor() && exit.getDestination().getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.targetActor = exit.getDestination().getActor();
                    break;
                }
            }
        }
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Override the getTargetActor method from Follower interface to get the targetActor that AlienBug will follow.
     *
     * @return the targetActor that AlienBug will follow
     */
    @Override
    public Actor getTargetActor() {
        return this.targetActor;
    }

    /**
     * Override the unconscious method from Actor class as AlienBug will drop all items in
     * its inventory (if there is item) when it falls unconscious.
     *
     * @param actor the actor that caused the AlienBug to fall unconscious
     * @param map   game map
     * @return a message indicating the AlienBug has fallen unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        Location putLocation = map.locationOf(this);
        map.removeActor(this);
        if (this.getItemInventory().size() > 0) {
            for (Item item : this.getItemInventory()) {
                putLocation.addItem(item);
            }
        }
        return this + " met their demise at the hand of " + actor;
    }
}
