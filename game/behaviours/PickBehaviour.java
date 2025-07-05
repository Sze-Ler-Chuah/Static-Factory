package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;

/**
 * A class that represents the PickBehaviour of an Actor in the game.
 * Created by :
 *
 * @author Sze Ler
 */
public class PickBehaviour implements Behaviour {
    /**
     * Override the getAction method from Behaviour class to return a PickUpAction if there is
     * an item in the current location of the Actor standing.
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return a PickUpAction if there is an item in the current location of the Actor standing else return null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location currentLocation = map.locationOf(actor);
        if (currentLocation.getItems().size() > 0) {
            return new PickUpAction(currentLocation.getItems().get(Utility.getRandIndex(currentLocation.getItems().size())));
        }
        return null;
    }
}
