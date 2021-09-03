package player;

import com.company.RPG_Game;

import java.util.Random;

public class Magic extends Hero {

    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int uvelichenie = RPG_Game.random.nextInt(25);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + uvelichenie);
        }
        System.out.println(this.getName() + " Увеличил урон героев: " + uvelichenie + " единиц");
    }
}
