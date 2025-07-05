package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.enums.Status;

/**
 * A class that represents the AttackBehaviour of an Actor in the game.
 * Created by :
 *
 * @author Sheng Jie
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Returns an AttackAction if there is an actor that is not hostile to the player in the adjacent location
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an AttackAction if there is an actor that is not hostile to the player in the adjacent location
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && !destination.getActor().hasCapability(Status.HOSTILE_TO_PLAYER)) {
                return new AttackAction(destination.getActor(), exit.getName());
            }
        }
        return null;
    }
}
