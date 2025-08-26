package com.intern.ssdemo.Repository;

import com.intern.ssdemo.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {
}
