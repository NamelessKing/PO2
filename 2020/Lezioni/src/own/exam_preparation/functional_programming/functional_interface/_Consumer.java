package own.exam_preparation.functional_programming.functional_interface;

import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        MyConsumer<Customer> customerConsumer = greetCustomerConsumerAnonymous;

        customerConsumer.test(new Customer("Tanjin","9999"));

    }


    static void greetCustomer(Customer customer){
        System.out.println(String.format("Hello %s",customer.customerName));
    }

    static MyConsumer<Customer> greetCustomerConsumerAnonymous = new MyConsumer<Customer>() {
        @Override
        public void accept(Customer customer) {
            System.out.println(String.format("Hello %s",customer.customerName));
        }
        @Override
        public void test (Customer customer){
            System.out.println(String.format("Hello test%s",customer.customerName));
        }
    };

    interface MyConsumer<T> extends Consumer<T>{
        void test (T t);
    }

    static Consumer<Customer> greetCustomerConsumerLambda =
            customer -> System.out.println(String.format("Hello %s",customer));

    static class Customer{
        public final String customerName;
        public final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
