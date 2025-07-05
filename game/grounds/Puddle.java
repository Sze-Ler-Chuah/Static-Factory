package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.features.Consumable;

/**
 * A class that represents the Puddle object in the game.
 * Created by:
 *
 * @author Jack Lim
 * Modified by:
 * @author Jack Lim, Sheng Jie
 */
public class Puddle extends Ground implements Consumable {

    /**
     * Constructor of Puddle.
     */
    public Puddle() {
        super('~');
    }

    @Override
    public String consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 1);
        return actor + " drinks from the puddle and gains 1 maximum health point";
    }

    @Override
    public String getItemFunction(Actor actor) {
        return actor + " drinks water from the puddle";
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {

        ActionList actions = super.allowableActions(actor, location, direction);

        if (location.containsAnActor() && actor.equals(location.getActor())) {
            actions.add(new ConsumeAction(this));
        }

        return actions;
    }

}

