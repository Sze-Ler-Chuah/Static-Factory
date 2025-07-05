package game.features;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface that represents the Follower feature of an Actor in the game.
 * Created by :
 *
 * @author Sze Ler
 */
public interface Follower {
    /**
     * getTargetActor method to get the targetActor that the Actor is following.
     *
     * @return the targetActor that the Actor is following
     */
    Actor getTargetActor();
}
