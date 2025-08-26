package com.intern.ssdemo.Controller;

import com.intern.ssdemo.DTO.StateDTO;
import com.intern.ssdemo.Models.State;
import com.intern.ssdemo.Service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/State")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity getAll(){
        List<State> states =stateService.getAll();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getByid(@PathVariable int id){
       return new ResponseEntity<>(stateService.getByid(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity add(@RequestBody StateDTO state){
        stateService.add(state);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody StateDTO state){
        stateService.update(id,state);
        return new ResponseEntity("Successfully updated",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        stateService.delete(id);
        return new ResponseEntity("Successfully deleted",HttpStatus.OK);
    }
}
