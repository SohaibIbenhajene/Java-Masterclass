package dev.sohaib;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    private Customer getCustomer(String customerName) {
        for (Customer customer: customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(String customerName, double initialDeposit) {
        if (getCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("Customer: " + customerName + " added to the customer database.");
        }
    }

    public void addTransaction(String name, double transaction) {
        Customer customer = getCustomer(name);
        if (customer != null) {
            customer.addTransactions(transaction);
            System.out.printf("Transaction of %f added for: %s", transaction, customer.getName());
        } else {
            System.out.println("Customer: " + name + " not inside of database.");
        }
    }

    public void printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        if (customer == null) {
            return;
        }
        System.out.println("Customer: " + customer.getName());
        System.out.println("Transactions:");
        for (double transaction: customer.getTransactions()) {
            System.out.printf("$%10.2f (%s)%n", transaction, transaction < 0 ? "debit" : "credit");
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
