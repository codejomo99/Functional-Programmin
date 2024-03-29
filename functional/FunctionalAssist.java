package functional;

import java.util.ArrayList;
import java.util.List;

public class FunctionalAssist {
    public static void main(String[] args){
        CustomerService service = new CustomerService();
        initData(service);

//        // 요구사항 1) 지역으로 검색
//        List<Customer> result = service.searchCustomersByLocation("Seoul");
////        for(Customer customer : result){
////            System.out.println(customer);
////        }
//
//        // 요구사항 2) 성별로 검색
//        List<Customer> result2 = service.searchCustomersByGender(Gender.Female);
////        for(Customer customer : result2){
////            System.out.println(customer);
////        }
//
//        // 메소드 한 번에
//        List<Customer> result3 = service.searchCustomersBy(SearchOption.Location,"Busan");
//        for(Customer customer : result3){
//            System.out.println(customer);
//        }
        List<Customer> result;

        result = service.searchCustomers(new SearchFilter() {
            @Override
            public boolean isMatched(Customer customer) {
                if(customer.getLocation().equals("Seoul")){
                    return true;
                }else {
                    return false;
                }
            }
        });

        // 람다 적용
        // result = service.searchCustomers(customer -> customer.getGender().equals(Gender.Female));

        result = service.searchCustomers(customer -> customer.getLocation().equals("Seoul") && customer.getAge() > 25);

        for(Customer customer : result){
            System.out.println(customer);
        }
    }



    public static void initData(CustomerService service){
        service.addCustomer(new Customer("CUSO1","Seoul", Gender.Male, 30));
        service.addCustomer(new Customer("CUSO2","Busan", Gender.Female, 40));
        service.addCustomer(new Customer("CUSO3","Seoul", Gender.Female, 13));
        service.addCustomer(new Customer("CUSO4","Gwangju", Gender.Male, 55));
        service.addCustomer(new Customer("CUSO5","Incheon", Gender.Female, 20));
        service.addCustomer(new Customer("CUSO6","Seoul", Gender.Male, 23));
        service.addCustomer(new Customer("CUSO7","Seoul", Gender.Female, 36));
        service.addCustomer(new Customer("CUSO8","Seoul", Gender.Male, 31));
        service.addCustomer(new Customer("CUSO9","Busan", Gender.Female, 55));
        service.addCustomer(new Customer("CUSO10","Gwangju", Gender.Male, 60));

    }
}
