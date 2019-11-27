package com.company.players;

import com.company.boss.Boss;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter(int health, int damage) {
        super(health, damage, Ability.CRITICAL_DAMAGE);
    }

    @Override
    public void applyAbility(Hero[] heroes, Boss boss) {
        /*
            Hunter каждый раз при атаке критует.
            Т.е. каждая атака умножается на случайное число от 2 до 4.
        */
        int randomNumber=new Random().nextInt(2)+2;
        this.setDamage(this.getDamage()*randomNumber);
    }
}
