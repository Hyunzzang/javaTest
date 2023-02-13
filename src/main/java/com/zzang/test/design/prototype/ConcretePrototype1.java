package com.zzang.test.design.prototype;

public class ConcretePrototype1 implements Prototype {
    private String field;

    public ConcretePrototype1(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(field);
    }

    public String getField() {
        return field;
    }
}
