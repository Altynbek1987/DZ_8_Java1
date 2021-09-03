package player;

import com.company.RPG_Game;

public class Tor extends Hero {
    public Tor(int health, int damage,  String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boolean tor = RPG_Game.randomB.nextBoolean();
        for (int i = 0; i < heroes.length; i++) {
            if (tor){
                System.out.println("Tor оглушил босса");
                heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage());
                break;
            }
        }
    }
}
