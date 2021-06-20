package com.company.players;

import java.util.Random;

public class Thor extends Hero {

    private String stunning;

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUNNING);
        this.stunning = stunning;
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

        Random random = new Random();
        int random2 = random.nextInt(4) + 1;

        for (int j = 0; j < heroes.length; j++) {
            if (heroes[j].getHealth() > 0 && boss.getHealth() > 0 && random2 == 3) {
                heroes[j].setHealth(heroes[j].getHealth() + 45);
                System.out.println("Thor stunned the Boss!");

            }
        }
        if (boss.getHealth() > 0 && random2 == 3) {
            boss.setHealth(boss.getHealth() + 20); //урон от способности танка
            heroes[6].setHealth(heroes[6].getHealth() + 35);
        }
    }
}