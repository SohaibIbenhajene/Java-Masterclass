public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 1000, "tim@gmail.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmailAddress());

        Customer secondCustomer = new Customer();
        System.out.println(secondCustomer.getName());
        System.out.println(secondCustomer.getCreditLimit());
        System.out.println(secondCustomer.getEmailAddress());

        Customer ThirdCustomer = new Customer("Joe", "joe@gmail.com");
        System.out.println(ThirdCustomer.getName());
        System.out.println(ThirdCustomer.getCreditLimit());
        System.out.println(ThirdCustomer.getEmailAddress());
    }
}
