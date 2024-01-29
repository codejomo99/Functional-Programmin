package functional;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService(){
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer newCustomer){
        this.customers.add(newCustomer);
    }

    // 요구사항 1) 지역으로 검색
    public List<Customer> searchCustomersByLocation(String location){
        List<Customer> foundCustomers = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getLocation().equals(location)){
                foundCustomers.add(customer);
            }
        }
        return  foundCustomers;
    }


}
