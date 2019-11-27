package com.company.players;

import com.company.boss.Boss;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, Ability.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applyAbility(Hero[] heroes, Boss boss) {
        /*
            Warrior должен получать от босса урон,
            и потом наносить ему свой урон + полученный от босса
        */
        boss.setHealth(boss.getHealth()-(this.getDamage()+boss.getDamage()));
    }
}
