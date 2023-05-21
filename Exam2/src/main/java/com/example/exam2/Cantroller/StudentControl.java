package com.example.exam2.Cantroller;

import com.example.exam2.ApiResponse.ApiResponse;
import com.example.exam2.Model.Student;
import com.example.exam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentControl {

    private final StudentService studentService;

    @GetMapping("/get")
    public ArrayList<Student> getStudent() {
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students).getBody();
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@Valid @RequestBody Student student, Errors errors, @PathVariable int id) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdate = studentService.updateStudent(id, student);
        if (isUpdate) {
            return ResponseEntity.status(200).body("Student Updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        boolean isDelete = studentService.deleteStudent(id);
        if (isDelete) {
            return ResponseEntity.status(200).body("Student Deleted");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @GetMapping("/search/{name}")
    public ResponseEntity searchStudent(@Valid @RequestBody Student students, @PathVariable String name, @PathVariable int id) {
        ArrayList<Student> students1 = new ArrayList<>();
        if (students.getName().equals(name)) ;
        students1.set(id,students);
        System.out.println("done");
        return null;
    }
}
