package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Ability;

/**
 *  A class that represents a HumanoidFigure in the game.
 *  HumanoidFigure extends from Actor class.
 *  Created by :
 * @author Yun Sion
 */
public class HumanoidFigure extends Actor {

    /**
     * Constructor for HumanoidFigure.
     * Adds BUY_SCRAP ability to let it buy scraps from the player.
     */
    public HumanoidFigure() {
        super("Humanoid Figure", 'H', 9999);
        this.addCapability(Ability.BUY_SCRAP);
    }

    /**
     * Returns an action to perform on the current turn.
     * Only DoNothingAction is allowed for the HumanoidFigure.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action to perform on the current turn.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
