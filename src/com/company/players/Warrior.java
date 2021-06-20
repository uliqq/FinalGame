package com.company.players;

import java.util.Random;

public class Warrior extends Hero {

    private int criticalDamage;

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    Random odd2 = new Random();
    int odd = odd2.nextInt(2) + 2;

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
            if (getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - getDamage() * odd);

        }
    }
}
