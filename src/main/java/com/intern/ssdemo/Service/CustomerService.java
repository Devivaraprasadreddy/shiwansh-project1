package com.intern.ssdemo.Service;

import com.intern.ssdemo.DTO.CustomerDTO;
import com.intern.ssdemo.Models.Customer;
import com.intern.ssdemo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public List<Customer> getAll(){
        List<Customer> customers= customerRepo.findAll();
        return customers;
    }

    public Customer getById(int id){
        Optional<Customer> customer=customerRepo.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        throw  new RuntimeException("Customer Not found");

    }
    public void add(CustomerDTO customerDTO){
        Customer customer=new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobile(customerDTO.getMobile());
        customer.setImage( customerDTO.getImage() );
        System.out.println(customer.getImage());

        customerRepo.save(customer);
    }
    public void update(int id, CustomerDTO customerDTO){
        System.out.println(customerDTO.getImage());
        System.out.println(customerDTO.getName());
       Customer customer=customerRepo.findById(id).get();
       if(customerDTO.getName()==null){
           throw  new RuntimeException("Customer Not found");
       }
       customer.setName(customerDTO.getName());
       customer.setEmail(customerDTO.getEmail());
       customer.setMobile(customerDTO.getMobile());
       customer.setImage( customerDTO.getImage() );
       System.out.println(customer.getImage());
       customerRepo.save(customer);
    }
    public void delete(int id){
        customerRepo.deleteById(id);
    }
}
