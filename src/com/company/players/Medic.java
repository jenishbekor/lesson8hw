package com.company.players;

import com.company.boss.Boss;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, Ability.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applyAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] != this && this.getHealth() > 0
                    && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
            }
        }
    }
}
