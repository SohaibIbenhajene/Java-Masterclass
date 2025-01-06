package dev.sohaib;

public abstract class ProductForSale {
    private String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(int quantity) {
        return quantity * price;
    }

    public final String getProductType() {
        return this.getClass().getSimpleName() + " - " + type;
    }

    public void printPricedItem(int quantity) {
        System.out.printf("Product: %10s Quantity: %d Price: %.2f Total: %.2f%n",
                type, quantity, price, getSalesPrice(quantity));
    }

    public abstract void showDetails();
}

class SmartPhone extends ProductForSale {

    public SmartPhone(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("%s Description: %10s Price: %.2f%n", getProductType(), description, price);
    }
}

class Laptop extends ProductForSale {

    public Laptop(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("%s Description: %10s Price: %.2f%n", getProductType(), description, price);
    }
}

class GamingConsole extends ProductForSale {

    public GamingConsole(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.printf("%s Description: %10s Price: %.2f%n", getProductType(), description, price);
    }
}