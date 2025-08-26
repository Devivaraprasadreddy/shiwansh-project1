package com.intern.ssdemo.Controller;

import com.intern.ssdemo.DTO.CountryDTO;
import com.intern.ssdemo.DTO.LanguageDTO;
import com.intern.ssdemo.Models.Country;
import com.intern.ssdemo.Models.Language;
import com.intern.ssdemo.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping
    public ResponseEntity getAll(){
        List<Country> countries= countryService.getAll();
        if(countries==null){
            return new ResponseEntity("No countries Added",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(countries, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getByid(@PathVariable int id){
        Country country = countryService.getByid(id);
        return new ResponseEntity(country,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity add(@RequestBody CountryDTO countryDTO){
          countryService.add(countryDTO);
          return new ResponseEntity("Country added",HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody CountryDTO countryDTO){
        countryService.update(id, countryDTO);
       return new ResponseEntity("Country updated",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        countryService.delete(id);
        return new ResponseEntity("Country deleted",HttpStatus.OK);
    }

}
