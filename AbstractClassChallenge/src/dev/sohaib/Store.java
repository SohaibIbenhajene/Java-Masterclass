package dev.sohaib;

import java.util.ArrayList;

record OrderItem (int quantity, ProductForSale productForSale) { }

public class Store {
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public Store(ArrayList<ProductForSale> productForSaleList) {
        storeProducts = productForSaleList;
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int quantity) {
        order.add(new OrderItem(quantity, storeProducts.get(orderIndex)));
    }

    public static void listProducts() {
        for (var item: storeProducts) {
            System.out.println("-".repeat(20));
            item.showDetails();
        }
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double salesTotal = 0;
        for (var item: order) {
            item.productForSale().printPricedItem(item.quantity());
            salesTotal += item.productForSale().getSalesPrice(item.quantity());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }

    public static void main(String[] args) {
        storeProducts.add(new Laptop("Gaming", 550, "Cool rgb gaming laptop"));
        storeProducts.add(new SmartPhone("Iphone 14", 1200, "High tech smartphone"));
        listProducts();

        System.out.println("Order 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 0, 3);
        addItemToOrder(order1, 1, 1);
        printOrder(order1);
    }
}
