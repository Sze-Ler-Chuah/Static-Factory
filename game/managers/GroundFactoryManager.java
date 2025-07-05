package game.managers;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GroundFactory;
import game.grounds.*;


/**
 * The GroundFactoryManager class is responsible for creating and managing the GroundFactory instances.
 * It provides static methods to get the GroundFactory for different game levels.
 *
 * Created by:
 * Jie Yang
 */
public class GroundFactoryManager {

    /**
     * Returns the GroundFactory for the Polymorphia level.
     *
     * @return an instance of FancyGroundFactory with the ground types required for the Polymorphia level.
     */
    public static GroundFactory getPolyMorphiaGroundFactory() {
        return new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new PolymorphiaTree(), new Puddle(), new ComputerTerminal());
    }

    /**
     * Returns the GroundFactory for the Refactorio level.
     *
     * @return an instance of FancyGroundFactory with the ground types required for the Refactorio level.
     */
    public static GroundFactory getRefactorioGroundFactory() {
        return new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new RefactorioTree(), new Puddle(), new ComputerTerminal());
    }

    /**
     * Returns the GroundFactory for the StaticFactory level.
     *
     * @return an instance of FancyGroundFactory with the ground types required for the StaticFactory level.
     */
    public static GroundFactory getStaticFactoryGroundFactory() {
        return new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle(), new ComputerTerminal());
    }
}
