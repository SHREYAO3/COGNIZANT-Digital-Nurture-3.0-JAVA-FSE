// DependencyInjectionTest.java
public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        String customerDetails = customerService.getCustomerDetails("12345");
        System.out.println(customerDetails);
    }
}
