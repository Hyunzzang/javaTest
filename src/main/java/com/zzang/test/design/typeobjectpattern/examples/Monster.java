package com.zzang.test.design.typeobjectpattern.examples;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private int health;
    private int speed;
    private int attack;
    private MonsterType type;

    public Monster(MonsterType type) {
        this.type = type;
        start();
    }

    private void start() {
        setHealth(type.getStartingHealth());
        setSpeed(type.getBaseSpeed());
        setAttack(type.getBaseAttack());
    }
}
