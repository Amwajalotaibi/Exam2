package com.example.exam2.Cantroller;

import com.example.exam2.ApiResponse.ApiResponse;
import com.example.exam2.Model.Teacher;
import com.example.exam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherControl {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ArrayList<Teacher> getTeacher() {
        ArrayList<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers).getBody();
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, Errors errors, @PathVariable int id) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        boolean isUpdate = teacherService.updateTeacher(id, teacher);
        if (isUpdate) {
            return ResponseEntity.status(200).body("Teacher Updated");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {
        boolean isDelete = teacherService.deleteTeacher(id);
        if (isDelete) {
            return ResponseEntity.status(200).body("Teacher Deleted");
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@Valid @RequestBody Teacher teacher, @PathVariable int id) {
        ArrayList<Teacher> teacher1 = new ArrayList<>();
        if (teacher.getId()==id) ;
        teacher1.set(id,teacher);
        System.out.println("done");
        return null;
    }

}
