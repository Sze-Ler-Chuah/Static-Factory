package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Sheng Jie
 */
public class Wall extends Ground {

    /**
     * Constructor of Wall.
     */
    public Wall() {
        super('#');
    }

    /**
     * Checks if the actor can enter the wall.
     *
     * @param actor The actor that wants to enter the wall.
     * @return false since the actor cannot enter the wall.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

}
