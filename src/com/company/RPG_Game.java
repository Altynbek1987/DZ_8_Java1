package com.company;

import player.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    public static Random randomB = new Random();

    public static void start() {
        Boss boss = new Boss(1000, 50);

        Warrior warrior = new Warrior(250, 15, "Warrior");
        Medic doc = new Medic(230, 10, 15, "Medic");
        Magic magic = new Magic(260, 25, "Magic");
        Berserk berserk = new Berserk(270, 20, "Berserk");
        Medic assistant = new Medic(250, 15, 5, "Medic assistant");
        Tor tor = new Tor(250,25,"Tor");
        Witcher witcher = new Witcher(310, 15, "Witcher");

        Hero[] heroes = {warrior, doc, magic, berserk, assistant,tor,witcher};
        printStatistics(boss, heroes);

        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHit(boss, heroes);
        heroesApplySuperPower(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
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

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("______________");
        System.out.println("Boss health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName()
                    + " health: " + heroes[i].getHealth() + " ["
                    + heroes[i].getDamage() + "]");
        }
    }

}
