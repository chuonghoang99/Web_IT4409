package Interface;

import Model.Customer;

import java.util.List;

public interface CustomerInterface {
    public boolean addCustomer(Customer customer);
    public List<Customer> getPaggingCustomer(int offset,int size);
    public List<Customer> getCustomer(String name);
}
