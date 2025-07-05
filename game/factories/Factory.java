package game.factories;

/**
 * A class that represents the Factory of an object in the game.
 * Created by : Sheng Jie
 *
 * @author Sheng Jie
 */
public interface Factory<A> {
    /**
     * createNew() returns a new object of type A.
     *
     * @return a new object of type A
     */
    A createNew();
}

