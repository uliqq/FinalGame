package com.company.general;

import com.company.players.*;

public class RPG_Game {

    public static void start() {

        Boss boss = new Boss(2500, 50);
        Warrior warrior = new Warrior(250, 10);
        Tank tank = new Tank(400, 10, 20);
        Magic magic = new Magic(250, 10, 2);
        Medic medic = new Medic(300, 5, 15);
        Medic youngMedic = new Medic(300, 5, 10);
        Thor thor = new Thor(400, 10);
        Golem golem = new Golem(600, 5);

        Hero[] heroes = {warrior, tank, magic, medic, youngMedic, thor, golem};

        printStatistics(boss, heroes);

        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_________________________________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth());
        }
        System.out.println("_________________________________");

    }


    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }

        }
        if (allHeroesDied) {
            System.out.println("Boss won!");
        }
        return allHeroesDied;
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
            if (boss.getHealth() <= 0) {
                boss.setHealth(0);
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
            if (heroes[i].getHealth() <= 0) {
                heroes[i].setHealth(0);
            }
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);
            if (boss.getHealth() <= 0) {
                boss.setHealth(0);
            }
            if (heroes[i].getHealth() <= 0) {
                heroes[i].setHealth(0);
            }
        }
    }
}
