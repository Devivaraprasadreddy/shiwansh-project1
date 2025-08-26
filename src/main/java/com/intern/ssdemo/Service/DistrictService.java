package com.intern.ssdemo.Service;

import com.intern.ssdemo.DTO.DistrictDTO;
import com.intern.ssdemo.Models.District;
import com.intern.ssdemo.Repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepo districtRepo;
    public List<District> getAll(){
          List<District> alldistricts= districtRepo.findAll();
          return alldistricts;
    }

    public District getByid(int id){
          Optional<District> district= districtRepo.findById(id);
          return district.get();
    }

    public void add(DistrictDTO districtDTO){
         District district = new District();
         district.setName(districtDTO.getName());
         district.setCountryId(districtDTO.getCountryId());
         district.setStateId(districtDTO.getStateId());
         districtRepo.save(district);

    }
    public void update(int id, DistrictDTO districtDTO){
         Optional<District> district = districtRepo.findById(id);
         District district1 = district.get();
         District newDistrict = new District();
         newDistrict.setName(district1.getName());
         newDistrict.setCountryId(district1.getCountryId());
         newDistrict.setStateId(district1.getStateId());

    }
    public void delete(int id){
        districtRepo.deleteById(id);
    }
}
