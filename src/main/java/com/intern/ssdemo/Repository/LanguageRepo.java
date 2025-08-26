package com.intern.ssdemo.Repository;

import com.intern.ssdemo.Models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {
}
