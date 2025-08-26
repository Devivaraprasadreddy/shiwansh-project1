package com.intern.ssdemo.Controller;

import com.intern.ssdemo.DTO.StudentDTO;
import com.intern.ssdemo.Models.Students;
import com.intern.ssdemo.Service.StudetnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Students")
public class StudentsController {

    @Autowired
    private StudetnsService studetnsService;

    @GetMapping
    public ResponseEntity GetAllStudents() {
        List<Students> students = studetnsService.GetAllStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity GetStudentById(@PathVariable int id) {
        Students students =studetnsService.GetStudentByID(id);
        return ResponseEntity.ok(students);
    }


    @PostMapping
    public ResponseEntity AddStudent(@RequestBody StudentDTO student) {
        studetnsService.AddStudent(student);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateStudent(@PathVariable int id, @RequestBody StudentDTO student) {
        studetnsService.UpdateStudent(id, student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteStudent(@PathVariable int id) {
        studetnsService.DeleteStudent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
