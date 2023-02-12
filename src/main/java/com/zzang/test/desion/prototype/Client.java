package com.zzang.test.desion.prototype;

public class Client {
    public static void main(String[] args) {
        Prototype prototype1 = new ConcretePrototype1("prototype1");
        Prototype prototype2 = new ConcretePrototype2(1);

        // 개선전
//        Prototype clone1 = new ConcretePrototype1(product1.getName(), product1.getPrice());
//        Prototype clone2 = new ConcretePrototype2(product2.getName(), product2.getPrice());

        Prototype clone1 = prototype1.clone();
        Prototype clone2 = prototype2.clone();

        System.out.println("Cloned: " + ((ConcretePrototype1)clone1).getField());
        System.out.println("Cloned: " + ((ConcretePrototype2)clone2).getField());
    }
}
