package com.company.players;

import com.company.boss.Boss;

public class Magic extends Hero {
    private int points;
    public Magic(int health, int damage, int points) {
        super(health, damage, Ability.BOOST);
        this.points=points;
    }


    @Override
    public void applyAbility(Hero[] heroes, Boss boss) {
        /*
            Magic должен увеличивать атаку каждого героя
            после каждого раунда на n-ное количество
        */

        for(Hero hero:heroes)
        {
            hero.setDamage(hero.getDamage()+this.points);
        }
    }
}
