package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utility;
/**
 * The TravelAction class represents an action that allows an actor to teleport to a random location on the map.
 * This class extends the Action class and overrides the execute and menuDescription methods.
 *
 * Created by
 * Jie Yang
 */
public class TravelAction extends Action {

    /**
     * This method is called when the action is performed. It generates a random x and y coordinate within the bounds of the map.
     * It then checks if the randomly generated location is occupied by another actor. If the location is occupied, it returns a message stating that the destination is blocked.
     * If the location is not occupied, it moves the actor to the new location and returns a message stating that the actor has traveled to the new location.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int x = Utility.getRandIndex(map.getXRange().max());
        int y = Utility.getRandIndex(map.getYRange().max());

        // Check if the position is valid
        if (map.at(x, y).containsAnActor()){
            return "The estimated destination is blocked by another actor and cannot be teleported to.";
        }

        // Add the action to move the actor to the random position
        else {
            map.moveActor(actor, map.at(x, y));
            return actor + " travels to " + "(" + map.at(x, y).x() + ", " + map.at(x, y).y() + ")";
        }
    }

    /**
     * This method returns a string that describes the action in the context of a menu. This description is used when displaying the action to the user in the user interface.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Player travels to random position"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to random position ";
    }
}
