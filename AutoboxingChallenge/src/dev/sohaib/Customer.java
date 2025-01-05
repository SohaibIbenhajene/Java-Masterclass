package dev.sohaib;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    public Customer(String name, double initialDeposit) {
        this(name, new ArrayList<>(500));
        addTransactions(initialDeposit);
    }

    public void addTransactions(double... transactions) {
        for (double transaction: transactions) {
            this.transactions.add(transaction);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
