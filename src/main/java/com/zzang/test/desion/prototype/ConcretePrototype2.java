package com.zzang.test.desion.prototype;

public class ConcretePrototype2 implements Prototype {
    private int field;

    public ConcretePrototype2(int field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(field);
    }

    public int getField() {
        return field;
    }

}
