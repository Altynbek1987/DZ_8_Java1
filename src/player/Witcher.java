package player;

public class Witcher extends Hero {



    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
