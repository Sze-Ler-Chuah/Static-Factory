package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.features.Follower;

import java.util.List;

/**
 * A class that represents the FollowBehaviour of an Actor in the game.
 * This allows an Actor to follow another Actor.
 * Created by :
 *
 * @author Sze Ler
 */
public class FollowBehaviour implements Behaviour {
    private final Follower actorFollow;

    public FollowBehaviour(Follower follower) {
        this.actorFollow = follower;
    }

    /**
     * Override the getAction method from Behaviour class to return a MoveActorAction to move the Actor towards the target Actor.
     * If the targetActor is not in the map, return null.
     * Else, find the exit that is closest to the targetActor and return a MoveActorAction to move the Actor towards the targetActor.
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Actor targetActor = this.actorFollow.getTargetActor();
        if (targetActor != null) {
            Location actorLocation = map.locationOf(actor);
            Location targetLocation = map.locationOf(targetActor);
            double currentDistance = distance(actorLocation, targetLocation);
            Action mostValidAction = new DoNothingAction();
            List<Exit> exits = actorLocation.getExits();
            for (Exit exit : exits) {
                Location destination = exit.getDestination();
                boolean canActorEnter = destination.canActorEnter(actor);
                if (canActorEnter) {
                    double newDistance = distance(destination, targetLocation);
                    if (newDistance < currentDistance) {
                        mostValidAction = new MoveActorAction(destination, exit.getName());
                        currentDistance = newDistance;
                    }
                }
            }
            return mostValidAction;
        }
        return null;
    }


    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}