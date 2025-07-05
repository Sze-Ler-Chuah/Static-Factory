package game.features;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for items that can be listened to.
 * Created by:
 * @Author Sze Ler
 */
public interface Monologueble {
    /**
     * Method for item to create all the monologues and return a random monologue.
     * @param actor
     * @return a string that represents the monologue
     */
    public String listenMonologue(Actor actor);

    /**
     * Method for item to return the function of the item.
     * @param actor
     * @return a string that represents the function of the item
     */
    public String getItemFunction(Actor actor);
}
