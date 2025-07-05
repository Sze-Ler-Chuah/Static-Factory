package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.enums.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by: Sheng Jie
 */
public class Floor extends Ground {

    /**
     * Constructor of Floor.
     */
    public Floor() {
        super('_');
    }

    /**
     * Checks if the actor can enter the floor.
     *
     * @param actor The actor that wants to enter the floor.
     * @return true if the actor can enter the floor, false otherwise.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENTER_FLOOR);
    }
}
