package game.managers;

import java.util.List;

/**
 * The GameMapManager class is responsible for managing the game maps.
 * It provides static methods to get the maps for the game.
 * Each map is represented as a list of strings, where each string represents a row of the map.
 * Different characters in the strings represent different types of terrain.
 *
 * Created by:
 * Jie Yang
 */
public class GameMapManager {

    /**
     * Returns the map for the Polymorphia level.
     *
     * @return a List of Strings, where each string represents a row of the map.
     */
    public static List<String> getPolymorphiaMap() {
        return List.of(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "...............,..............",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~"
        );
    }

    /**
     * Returns the map for the Refactorio level.
     *
     * @return a List of Strings, where each string represents a row of the map.
     */
    public static List<String> getRefactorioMap() {
        return List.of(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..............,...........~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");
    }

    /**
     * Returns the map for the StaticFactory level.
     *
     * @return a List of Strings, where each string represents a row of the map.
     */
    public static List<String> getStaticFactoryMap() {
        return List.of(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......");
    }

}
