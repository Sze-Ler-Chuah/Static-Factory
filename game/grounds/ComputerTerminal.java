package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PurchaseAction;
import game.factories.Factory;
import game.features.Purchasable;
import game.items.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a ComputerTerminal in the game.
 * Created by:
 *
 * @author Sheng Jie
 */
public class ComputerTerminal extends Ground {

    /**
     * A list of factories that creates purchasable items.
     */
    private final List<Factory<Purchasable>> purchasableFactories = new ArrayList<>();
    /**
     * A list of MoveActorAction that allows actor to travel to different locations.
     */
    private List<MoveActorAction> moveActorActions = new ArrayList<>();

    /**
     * Constructor.
     */
    public ComputerTerminal() {
        super('=');
        setUpFactories();
    }

    /**
     * Set up the item injectors.
     */
    protected void setUpFactories() {
        purchasableFactories.add(DragonSlayerSword::new);
        purchasableFactories.add(EnergyDrink::new);
        purchasableFactories.add(ToiletPaperRoll::new);
        purchasableFactories.add(Astley::new);
        purchasableFactories.add(Theseus::new);
    }

    /**
     * Returns the allowable actions for the actor in the location.
     *
     * @param actor     the actor that is on the location
     * @param location  the location that the actor is on
     * @param direction the direction of the actor
     * @return a list of allowable actions for the actor
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        for (Factory<Purchasable> purchasableFactory : purchasableFactories) {
            actions.add(new PurchaseAction(purchasableFactory.createNew()));
        }

        //for loop a list of actions
        for (MoveActorAction action : moveActorActions) {
            actions.add(action);
        }
        return actions;
    }

    /**
     * Add a MovaActor action to the computer terminal.
     *
     * @param newAction the new action to be added
     */
    public void addTravel(MoveActorAction newAction) {
        this.moveActorActions.add(newAction);
    }
}