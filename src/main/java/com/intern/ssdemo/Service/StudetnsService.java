package com.intern.ssdemo.Service;

import com.intern.ssdemo.DTO.StudentDTO;
import com.intern.ssdemo.Models.Students;
import com.intern.ssdemo.Repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudetnsService {
    @Autowired
    private StudentsRepo studentsRepo;
    public List<Students> GetAllStudents() {
       List<Students> students=studentsRepo.findAll();
       return students;
    }
    public Students GetStudentByID(int id) {
        return studentsRepo.findById(id).get();
    }
    public void AddStudent(StudentDTO studentdto) {
        Students students=new Students();
        students.setName(studentdto.getName());
        students.setEmail(studentdto.getEmail());
        students.setMobile(studentdto.getMobile());
        students.setGenderId(studentdto.getGenderId());
        students.setDistrictId(studentdto.getDistrictId());
        students.setStateId(studentdto.getStateId());
        students.setCountryId(studentdto.getCountryId());
        studentsRepo.save(students);
    }
    public void UpdateStudent(int id,StudentDTO studentdto) {
        Students students = studentsRepo.findById(id).get();
        students.setName(studentdto.getName());
        students.setEmail(studentdto.getEmail());
        students.setMobile(studentdto.getMobile());
        students.setGenderId(studentdto.getGenderId());
        students.setDistrictId(studentdto.getDistrictId());
        students.setStateId(studentdto.getStateId());
        students.setCountryId(studentdto.getCountryId());
        studentsRepo.save(students);
    }
    public void DeleteStudent(int id) {
        studentsRepo.deleteById(id);
    }
}
