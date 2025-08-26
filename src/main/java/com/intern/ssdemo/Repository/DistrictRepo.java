package com.intern.ssdemo.Repository;

import com.intern.ssdemo.Models.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepo extends JpaRepository<District, Integer> {
}
