package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.features.Monologueble;

/**
 * Action that allows an actor to listen to a monologue.
 * Created by:
 * @Author Sze Ler
 */

public class ListenAction extends Action{
    /**
     * The monologue item that the actor can listen to.
     */
    private Monologueble monologue;

    /**
     * Constructor for ListenAction.
     * @param monologue
     */
    public ListenAction(Monologueble monologue){
        this.monologue = monologue;
    }
    /**
     * Executes the action of listening to the monologue.
     * @param actor the actor performing the action
     * @param map   the map where the action is being performed
     * @return a string describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return monologue.listenMonologue(actor);
    }

    /**
     * Returns a string describing the action of listening to the monologue.
     * @param actor The actor performing the action.
     * @return a string describing the action of listening to the monologue
     */
    @Override
    public String menuDescription(Actor actor) {
        return monologue.getItemFunction(actor);
    }

}
