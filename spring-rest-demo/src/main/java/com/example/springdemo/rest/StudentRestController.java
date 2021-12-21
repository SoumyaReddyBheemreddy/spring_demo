package com.example.springdemo.rest;

import com.example.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    //define @PostConstruct to load  the student data
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Soumya","Reddy"));
        students.add(new Student("Shashi","Kanth"));
        students.add(new Student("Arjun","Lokesh"));
    }

    //define endpoint for /students - return list of students
    // here jackson automatically converts POJO to Json
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    //define endpoint for /student/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list ...
        //check the studentId against list size
        if(studentId>=students.size())
            throw new StudentNotFoundException("Student id not found - "+studentId);

        return students.get(studentId);
    }


}
