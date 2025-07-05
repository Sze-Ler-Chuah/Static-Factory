package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.enums.Status;

/**
 * A class that represents a SuspiciousAstronaut in the game.
 * SuspiciousAstronaut extends from Enemy class.
 * * Created by :
 * * @author Sze Ler, Yun Sion
 */

public class SuspiciousAstronaut extends Enemy {
    /**
     * Constant variable representing the priority of the AttackBehaviour of SuspiciousAstronaut.
     */
    private static final int ATTACK_PRIORITY = 0;

    /**
     * Constructor for SuspiciousAstronaut.
     * Add 1 behaviour to SuspiciousAstronaut, AttackBehaviour.
     * Add HOSTILE_TO_PLAYER capability to SuspiciousAstronaut to allow SuspiciousAstronaut to attack the player.
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.putBehaviour(ATTACK_PRIORITY, new AttackBehaviour());
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * Override the getIntrinsicWeapon method from Actor class to return the intrinsic weapon of the SuspiciousAstronaut.
     * The intrinsic weapon of the SuspiciousAstronaut is a weapon that deals 1000 damage and has 100% accuracy
     * which will instantly kills the intern.
     *
     * @return an IntrinsicWeapon object representing the SuspiciousAstronaut's intrinsic weapon.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1000, "kills", 100);
    }

    /**
     * Override the allowableActions method from Actor class to modify the health of the other Actor to 0 if the
     * other Actor has been attacked by the SuspiciousAstronaut.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return an ActionList object representing the list of allowable actions for the other Actor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (!otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            otherActor.modifyAttribute(BaseActorAttributes.HEALTH, ActorAttributeOperations.UPDATE, 0);
        }
        return actions;
    }

}