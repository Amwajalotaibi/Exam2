package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {

    @NotNull(message = "Should be not Null")
    private int id;

    @NotEmpty(message = "Should be not Empty")
    private String name;

    @NotNull(message = "Should be not Null")
    private int Salary;
}
