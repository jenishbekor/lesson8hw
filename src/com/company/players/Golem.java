package com.company.players;

import com.company.boss.Boss;

public class Golem extends Hero {
    private int damagePoints;

    public Golem(int health, int damage, int damagePoints) {
        super(health, damage, Ability.INCREASED_LIFE);
        this.damagePoints = damagePoints;
    }

    @Override
    public void applyAbility(Hero[] heroes, Boss boss) {
        /*
            Добавить еще игрока, Golem,
            имеет увеличенную жизнь но слабый удар.
            Может принимать часть удара босса на других игроков себе
        */
        for (Hero hero : heroes) {
            if (hero != this && hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() + damagePoints);
                this.setHealth(this.getHealth() - damagePoints);
            }
        }

    }
}
