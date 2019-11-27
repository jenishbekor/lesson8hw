package com.company.game;

import com.company.boss.Boss;
import com.company.players.*;

public class RPGGame {
    public static void startGame() {
        Boss boss = new Boss(1200, 50);
        Warrior warrior = new Warrior(100, 10);
        Medic medic = new Medic(100, 10, 5);
        Hunter hunter = new Hunter(100, 10);
        Magic magic = new Magic(100, 10, 5);
        Golem golem = new Golem(200, 1, 3);
        Thor thor = new Thor(100, 10);
        Hero[] heroes = {warrior, medic, hunter, magic, golem, thor};

        printStatistics(heroes, boss);
        while (!isFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("___________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("___________");
    }

    private static void round(Hero[] heroes, Boss boss) {
        heroesHit(heroes, boss);
        if (boss.getCanHit()) {
            bossHit(heroes, boss);
        }
        heroesUseAbilities(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static boolean isFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void bossHit(Hero[] heroes, Boss boss) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesUseAbilities(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applyAbility(heroes, boss);
        }
    }
}
