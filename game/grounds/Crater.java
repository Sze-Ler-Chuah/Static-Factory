package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utility;
import game.actors.Enemy;
import game.factories.Factory;

/**
 * A class that represents the Crater object in the game.
 * Created by
 *
 * @author Sheng Jie
 * Modified by :
 * @author Sze Ler, Yun Sion
 */
public class Crater extends Ground {
    /**
     * The Factory object that creates the Actor object.
     */
    private final Factory<Enemy> creature;

    /**
     * The spawn rate of the Actor object.
     */
    private final double spawnRate;

    /**
     * Crater constructor accepts an Enemy object to be spawned together with its spawn rate
     *
     * @param creature
     * @param spawnRate
     */

    public Crater(Factory<Enemy> creature, double spawnRate) {
        super('u');
        this.creature = creature;
        this.spawnRate = spawnRate;
    }

    /**
     * Ticks the Ground object by spawning the Actor object into the game.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (Utility.getProbability(spawnRate) && !location.containsAnActor()) {
            location.addActor(creature.createNew());
        }
    }
}