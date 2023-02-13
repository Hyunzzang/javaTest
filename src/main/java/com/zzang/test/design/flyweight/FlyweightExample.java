package com.zzang.test.design.flyweight;

public class FlyweightExample {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f1 = factory.getFlyweight(1);
        Flyweight f2 = factory.getFlyweight(2);
        Flyweight f3 = factory.getFlyweight(3);
        Flyweight f4 = factory.getFlyweight(1);

        f1.operation(100);
        f2.operation(200);
        f3.operation(300);
        f4.operation(400);

        System.out.println("Number of Flyweight objects created: " + factory.getFlyweights().size());
    }
}
