package com.pack.Service;

import com.pack.data.Data;
import com.pack.domain.Student;

public class Tester {

    //This is tester
    public static void main(String[] args) {
        var data = new Data();
        var student = data.getIdClass().entrySet().stream().map(entry -> {
            Student myObj = new Student();
            myObj.setId(entry.getKey());
            myObj.setStudentClass(entry.getValue());
            return myObj;
        }).toList();

        var id = student.stream().filter(e -> e.getStudentClass() > 5)
                .map(Student::getId)
                .toList();

        id.stream().map(e -> data.getIdData().get(e)).forEach(System.out::println);


    }
}
