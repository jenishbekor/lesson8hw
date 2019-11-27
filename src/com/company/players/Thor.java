package com.company.players;

import com.company.boss.Boss;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, Ability.STUN);
    }

    @Override
    public void applyAbility(Hero[] heroes, Boss boss) {
        if(boss.getCanHit())
        {
            boss.setCanHit(new Random().nextBoolean());
        }
        else
        {
            boss.setCanHit(true);
        }
    }
}
