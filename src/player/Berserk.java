package player;

import com.company.RPG_Game;

public class Berserk extends Hero {

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int uron = RPG_Game.random.nextInt(50);
        boss.setHealth(boss.getHealth() - (this.getDamage() + uron));
        System.out.println(this.getName() + " + часть урона полученного от босса: " + uron);

    }

}
