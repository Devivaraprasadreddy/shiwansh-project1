package com.intern.ssdemo.Repository;

import com.intern.ssdemo.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer> {
}
