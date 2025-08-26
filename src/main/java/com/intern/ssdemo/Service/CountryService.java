package com.intern.ssdemo.Service;

import com.intern.ssdemo.DTO.CountryDTO;
import com.intern.ssdemo.Models.Country;
import com.intern.ssdemo.Repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;
    public List<Country> getAll(){
        List<Country> countries= countryRepo.findAll();
        return countries;
    }
    public Country getByid(int id){
        Country country=countryRepo.getById(id);
        return country;
    }
    public void add( CountryDTO countryDTO){
        Country country=new Country();
        country.setName(countryDTO.getName());
        countryRepo.save(country);
    }
    public void update(int id, CountryDTO countryDTO){
        Country country=countryRepo.getById(id);
        country.setName(countryDTO.getName());
        countryRepo.save(country);
    }
    public void delete(int id){
        countryRepo.deleteById(id);
    }
}
