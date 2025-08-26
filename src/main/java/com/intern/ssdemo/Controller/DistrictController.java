package com.intern.ssdemo.Controller;

import com.intern.ssdemo.DTO.DistrictDTO;
import com.intern.ssdemo.Models.District;
import com.intern.ssdemo.Service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Districts")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @GetMapping
    public ResponseEntity getAll(){
         List<District> districts=districtService.getAll();
         return new ResponseEntity(districts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getByid(@PathVariable int id){
         return new ResponseEntity(districtService.getByid(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity add(@RequestBody DistrictDTO districtDTO){
        districtService.add(districtDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody DistrictDTO districtDTO){
        districtService.update(id,districtDTO);
        return new ResponseEntity("Sucefully updated",HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        districtService.delete(id);
        return  new ResponseEntity("Sucefully deleted",HttpStatus.OK);
    }
}
