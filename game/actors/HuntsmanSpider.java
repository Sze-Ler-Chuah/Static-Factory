package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * A class that represents the Huntsman Spider.
 * Created by :
 *
 * @author Sheng Jie
 * Modified by :
 * @author Sze Ler
 */
public class HuntsmanSpider extends Enemy {
    /**
     * Constant variable representing the priority of the AttackBehaviour of Huntsman Spider.
     */
    private static final int ATTACK_PRIORITY = 0;

    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.putBehaviour(ATTACK_PRIORITY, new AttackBehaviour());
    }

    /**
     * Returns the intrinsic weapon of the Huntsman Spider.
     *
     * @return an IntrinsicWeapon object representing the Huntsman Spider's intrinsic weapon.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "kick", 25);
    }

}
