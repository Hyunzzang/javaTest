package com.zzang.test.desion.typeobjectpattern.examples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MonsterType {
    private int startingHealth;
    private int baseSpeed;
    private int baseAttack;
}
