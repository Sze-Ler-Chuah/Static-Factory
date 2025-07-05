package game;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.*;
import game.factories.Factory;
import game.grounds.*;
import game.items.*;
import game.managers.GameMapManager;
import game.managers.GroundFactoryManager;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by: Sheng Jie, Sze Ler, Sion, Jack
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        // Create game map instances here
        GameMap polyMorphiaMap = new GameMap(GroundFactoryManager.getPolyMorphiaGroundFactory(), GameMapManager.getPolymorphiaMap());
        GameMap refactorioMap = new GameMap(GroundFactoryManager.getRefactorioGroundFactory(), GameMapManager.getRefactorioMap());
        GameMap staticFactoryMap = new GameMap(GroundFactoryManager.getStaticFactoryGroundFactory(), GameMapManager.getStaticFactoryMap());

        // Add game map instances to the world
        world.addGameMap(polyMorphiaMap);
        world.addGameMap(refactorioMap);
        world.addGameMap(staticFactoryMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        // Add Crater here
        Factory<Enemy> enemyFactory = HuntsmanSpider::new;
        polyMorphiaMap.at(10, 5).setGround(new Crater(enemyFactory, 0.1));
        enemyFactory = AlienBug::new;
        polyMorphiaMap.at(4, 5).setGround(new Crater(enemyFactory, 0.1));
        enemyFactory = SuspiciousAstronaut::new;
        polyMorphiaMap.at(23, 5).setGround(new Crater(enemyFactory, 0.05));

        // Position of ComputerTerminal in different maps
        final int polyComputerX = 15;
        final int polyComputerY = 5;

        final int refactorioComputerX = 15;
        final int refactorioComputerY = 5;

        final int staticFactoryComputerX = 3;
        final int staticFactoryComputerY = 2;

        // Add ComputerTerminal in PolyMorphia
        ComputerTerminal computerTerminal = new ComputerTerminal();
        polyMorphiaMap.at(polyComputerX, polyComputerY).setGround(computerTerminal);
        // Add travel actions to the computer terminal in different maps other than PolyMorphia
        computerTerminal.addTravel(new MoveActorAction(refactorioMap.at(polyComputerX, polyComputerY), "to the Refactorio"));
        computerTerminal.addTravel(new MoveActorAction(staticFactoryMap.at(staticFactoryComputerX, staticFactoryComputerY), "to the Static Factory"));

        // Add ComputerTerminal in Refactorio
        computerTerminal = new ComputerTerminal();
        refactorioMap.at(refactorioComputerX, refactorioComputerY).setGround(computerTerminal);
        // Add travel actions to the computer terminal in different maps other than Refactorio
        computerTerminal.addTravel(new MoveActorAction(staticFactoryMap.at(3, 2), "to the Static Factory"));
        computerTerminal.addTravel(new MoveActorAction(polyMorphiaMap.at(15, 5), "to the PolyMorphia"));

        // Add ComputerTerminal in StaticFactory
        computerTerminal = new ComputerTerminal();
        staticFactoryMap.at(3, 2).setGround(computerTerminal);
        // Add travel actions to the computer terminal in different maps other than StaticFactory
        computerTerminal.addTravel(new MoveActorAction(polyMorphiaMap.at(15, 5), "to the PolyMorphia"));
        computerTerminal.addTravel(new MoveActorAction(refactorioMap.at(15, 5), "to the Refactorio"));

        // Add LargeBolt here
        Factory<Item> factory = LargeBolt::new;
        polyMorphiaMap.at(10, 8).addItem(factory.createNew());
        polyMorphiaMap.at(10, 9).addItem(factory.createNew());

        // Add MetalSheet here
        factory = MetalSheet::new;
        polyMorphiaMap.at(10, 10).addItem(factory.createNew());
        polyMorphiaMap.at(10, 11).addItem(factory.createNew());

        // Add MetalPipe
        factory = MetalPipe::new;
        polyMorphiaMap.at(10, 12).addItem(factory.createNew());

        // Add PotOfGold
        factory = PotOfGold::new;
        polyMorphiaMap.at(10, 13).addItem(factory.createNew());

        // Add JarOfPickles
        factory = JarOfPickles::new;
        polyMorphiaMap.at(10, 14).addItem(factory.createNew());

        // Add Player
        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, polyMorphiaMap.at(15, 6));

        // Add HumanoidFigure
        HumanoidFigure humanoidFigure = new HumanoidFigure();
        staticFactoryMap.at(3, 6).addActor(humanoidFigure);

        player.addBalance(100000);

        world.run();
    }
}