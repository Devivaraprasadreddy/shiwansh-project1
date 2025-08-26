package com.intern.ssdemo.Controller;

import com.intern.ssdemo.DTO.CountryDTO;
import com.intern.ssdemo.DTO.LanguageDTO;
import com.intern.ssdemo.Models.Language;
import com.intern.ssdemo.Service.LanguageServie;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/Language")
public class LanguageController {
    @Autowired
    private LanguageServie languageServie;
    @GetMapping
    public ResponseEntity GetAllCountries() {
        List<Language> languages= languageServie.getAll();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getCountryByid(@PathVariable int id) {
        Language language = languageServie.getByid(id);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }
    @PostMapping
    public  ResponseEntity addCountry(@RequestBody LanguageDTO language) {
        languageServie.add(language);
        return new ResponseEntity<>(language, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteCountry(@PathVariable int id) {
        languageServie.delete(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity updateCountry(@PathVariable  int id,@RequestBody LanguageDTO languageDTO) {
        languageServie.update(id, languageDTO);
        return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
    }
}
