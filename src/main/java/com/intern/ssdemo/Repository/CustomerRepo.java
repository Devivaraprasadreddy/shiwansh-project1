package com.intern.ssdemo.Repository;

import com.intern.ssdemo.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
