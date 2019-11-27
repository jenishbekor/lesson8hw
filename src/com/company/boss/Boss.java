package com.company.boss;

import com.company.players.GameEntity;

public class Boss extends GameEntity {
    private boolean canHit;
    public Boss(int health, int damage) {
        super(health, damage);
        this.canHit=true;
    }

    public boolean getCanHit() {
        return canHit;
    }

    public void setCanHit(boolean canHit) {
        this.canHit = canHit;
    }
}
