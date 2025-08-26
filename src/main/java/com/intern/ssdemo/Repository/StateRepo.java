package com.intern.ssdemo.Repository;

import com.intern.ssdemo.Models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {
}
