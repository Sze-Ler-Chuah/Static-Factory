package game;

import java.util.Random;

/**
 * Utility class
 * This class is used to store utility methods that are used in the game.
 * Created by:
 *
 * @author Sheng Jie, Sze Ler
 */
public class Utility {

    /**
     * This method is used to get a random number between 0 and 1 and compare it with the probability.
     *
     * @param probability the probability of the event happening
     * @return true if the random number is less than the probability, false otherwise
     */
    public static boolean getProbability(double probability) {
        return Math.random() <= probability;
    }

    /**
     * This method is used to get a random index between 0 and size.
     *
     * @param size the size of the list
     * @return a random index between 0 and size
     */
    public static int getRandIndex(int size) {
        Random random = new Random();
        return random.nextInt(size);
    }

    public static int getRandInt() {
        Random random = new Random();
        return random.nextInt(999 - 100 + 1) + 100;
    }
}
