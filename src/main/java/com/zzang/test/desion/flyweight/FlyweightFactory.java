package com.zzang.test.desion.flyweight;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

// ConcreteFlyweight 객체를 관리하고 공유 할 수 있는 기능 제공
public class FlyweightFactory {
    @Getter
    private Map<Integer, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(int key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}
