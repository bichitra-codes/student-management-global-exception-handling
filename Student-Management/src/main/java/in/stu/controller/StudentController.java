package in.stu.controller;

import in.stu.Service.StudentService;
import in.stu.entity.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/create")
    public ResponseEntity<StudentData> createStudent(@RequestBody StudentData student) {

        StudentData createStudent = service.createStudent(student);

        return new ResponseEntity<>(createStudent, HttpStatus.CREATED);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentData> getStudentById(@PathVariable Integer id) {

        StudentData studentById = service.getStudentById(id);

        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @GetMapping("/roll-number/{rollNumber}")
    public ResponseEntity<StudentData> getStudentByRollNumber(@PathVariable String rollNumber) {

        StudentData studentByRollNumber = service.getStudentByRollNumber(rollNumber);
        return  new ResponseEntity<>(studentByRollNumber, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentData>>  getAllStudents() {

        List<StudentData> allStudent = service.getAllStudents();

        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StudentData> updateStudent(@PathVariable Integer id, @RequestBody StudentData student) {

        StudentData updateStudent = service.updateStudent(id,student);

        return  new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {

        String deleteStudent = service.deleteStudent(id);

        return new ResponseEntity<>(deleteStudent, HttpStatus.OK);
    }
}
