package com.company.players;

public class Tank extends Hero {

    private int savedDamage;

    public Tank(int health, int damage, int savedDamage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        this.savedDamage = savedDamage;
    }

    public int getSavedDamage() {
        return savedDamage;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (getHealth() > 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - savedDamage);
        }

    }
}
