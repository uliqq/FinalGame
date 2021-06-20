package com.company.players;

public class Golem extends Hero {

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.TEAM_DEFENCE);

    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + 5);
            }
            }
            setHealth(getHealth() - boss.getDamage() / 10 * heroes.length);

        }
    }
