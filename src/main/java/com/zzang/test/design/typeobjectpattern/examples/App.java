package com.zzang.test.design.typeobjectpattern.examples;

public class App {

    public static void main(String[] args) {

        MonsterType dragonType = MonsterType.builder()
                .baseAttack(200)
                .baseSpeed(10)
                .startingHealth(100)
                .build();
        MonsterType trollType = MonsterType.builder()
                .baseAttack(100)
                .baseSpeed(50)
                .startingHealth(200)
                .build();

        Monster dragon = new Monster(dragonType);
        Monster troll = new Monster((trollType));

        System.out.println("dragon attack: " + dragon.getAttack());
        System.out.println("troll attack: " + troll.getAttack());
    }
}
