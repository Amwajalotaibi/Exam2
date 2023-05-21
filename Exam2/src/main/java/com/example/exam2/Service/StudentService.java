package com.example.exam2.Service;

import com.example.exam2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(int id ,Student student){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id ){
        for (int i = 0; i <students.size() ; i++) {
            if (students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
