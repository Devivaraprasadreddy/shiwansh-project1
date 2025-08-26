package com.intern.ssdemo.Service;

import com.intern.ssdemo.DTO.StateDTO;
import com.intern.ssdemo.Models.State;
import com.intern.ssdemo.Repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepo stateRepo;
    public List<State> getAll(){
        List<State> states= stateRepo.findAll();
        return states;
    }
    public State getByid(int id){
          return stateRepo.findById(id).get();
    }
    public void add(StateDTO stateDTO){
         State state = new State();
         state.setName(stateDTO.getName());
         state.setCountryId(stateDTO.getCountryId());
         stateRepo.save(state);
    }
    public void update(int id, StateDTO stateDTO){
        State state = stateRepo.findById(id).get();
        state.setName(stateDTO.getName());
        state.setCountryId(stateDTO.getCountryId());
        stateRepo.save(state);
    }
    public void delete(int id){
        stateRepo.deleteById(id);
    }
}
