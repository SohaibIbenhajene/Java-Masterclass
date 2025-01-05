package dev.sohaib;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        return branch.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction);
    }

    private Branch findBranch(String branchName) {
        for (Branch branch: branches) {
            if (branch.getName().equalsIgnoreCase(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        System.out.printf("Customer details for branch %s%n", branchName);
        int i = 1;
        for (Customer customer: branch.getCustomers()) {
            System.out.printf("Customer: %s[%d]%n", customer.getName(), i);
            i++;
            if (printTransactions) {
                System.out.println("Transactions");
                int j = 1;
                for (double transaction: customer.getTransactions()) {
                    System.out.printf("[%d] Amount %.2f%n", j, transaction);
                    j++;
                }
            }
        }
        return true;
    }
}
