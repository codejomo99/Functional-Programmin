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

    // 요구사항 2) 성별로 검색
    public List<Customer> searchCustomersByGender(Gender gender){
        List<Customer> foundCuntomers = new ArrayList<>();
        for(Customer cutomer : customers){
            if(cutomer.getGender().equals(gender)){
                foundCuntomers.add(cutomer);
            }
        }
        return foundCuntomers;
    }

    // 하나에 메소드로 제작
    public List<Customer> searchCustomersBy(SearchOption searchOption, String searchValue){
        List<Customer> foundCustomers = new ArrayList<>();
        for(Customer customer : customers){
            if(searchOption.equals(SearchOption.Location)){
                if(customer.getLocation().equals(searchValue)){
                    foundCustomers.add(customer);
                }
            }else if(searchOption.equals(SearchOption.Gender)){
                if(customer.getGender().name().equals(searchValue)){
                    foundCustomers.add(customer);
                }
            }
        }
        return foundCustomers;
    }


}
