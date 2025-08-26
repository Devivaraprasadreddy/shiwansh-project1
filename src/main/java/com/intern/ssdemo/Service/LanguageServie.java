package com.intern.ssdemo.Service;

import com.intern.ssdemo.DTO.LanguageDTO;
import com.intern.ssdemo.Models.Language;
import com.intern.ssdemo.Repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServie {
    @Autowired
    private LanguageRepo languagerepo;
    public List<Language> getAll(){
        List<Language> languages= languagerepo.findAll();
        return languages;
    }
    public Language getByid(int id){
        Optional<Language> language =languagerepo.findById(id);
        return language.get();
    }
    public void add(LanguageDTO languageDTO){
            Language language = new Language();
            language.setName(languageDTO.getName());
            System.out.println(language.getName());
            languagerepo.save(language);
    }
    public void update(int id, LanguageDTO languageDTO){
          Optional<Language> language =languagerepo.findById(id);
          Language language1 = language.get();
          language1.setName(languageDTO.getName());
          languagerepo.save(language1);
    }
    public void delete(int id){
        languagerepo.deleteById(id);
    }
}
