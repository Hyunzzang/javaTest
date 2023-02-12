package com.zzang.test.desion.typeobjectpattern.gpt;

public class Product {
    private ProductType productType;
    private int price;

    public Product(ProductType productType, int price) {
        this.productType = productType;
        this.price = price;
    }

    public int getDiscount() {
        return price - (price * productType.getDiscount() / 100);
    }

    public class ProductType {
        private int id;
        private String name;
        private int discount;

        public ProductType(int id, String name, int discount) {
            this.id = id;
            this.name = name;
            this.discount = discount;
        }

        public int getDiscount() {
            return discount;
        }
    }
}
