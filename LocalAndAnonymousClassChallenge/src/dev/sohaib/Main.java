package dev.sohaib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, int hireDate) {
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Zaya", "James", 2022));
        employees.add(new Employee("John", "Stones", 2024));
        employees.add(new Employee("Peter", "Stevenson", 2023));
        employees.add(new Employee("Robbie", "Shapiro", 2022));

        displayEmployees(employees, "fullname");
        System.out.println();
        displayEmployees(employees, "year");
    }

    public static void displayEmployees(List<Employee> employeeList, String sortField) {
        class EmployeeWrapper {
            private Employee employee;
            private String fullName;
            private int yearsWorked;

            public EmployeeWrapper(Employee employee) {
                this.employee = employee;
                this.fullName = employee.firstName() + " " + employee.lastName();
                this.yearsWorked = LocalDate.now().getYear() - employee.hireDate();
            }
        }

        List<EmployeeWrapper> employeeWrapperList = new ArrayList<>();
        for (Employee employee: employeeList) {
            employeeWrapperList.add(new EmployeeWrapper(employee));
        }

        var c0 = new Comparator<EmployeeWrapper>() {

            @Override
            public int compare(EmployeeWrapper o1, EmployeeWrapper o2) {
                if (sortField.equalsIgnoreCase("fullname")) {
                    return o1.fullName.compareTo(o2.fullName);
                }
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        employeeWrapperList.sort(c0);

        for (EmployeeWrapper employeeWrapper: employeeWrapperList) {
            System.out.println(employeeWrapper.fullName + " has worked for " + employeeWrapper.yearsWorked + " years");
        }
    }
}
