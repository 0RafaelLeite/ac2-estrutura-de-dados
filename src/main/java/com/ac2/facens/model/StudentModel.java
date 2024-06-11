package com.ac2.facens.model;

import java.time.LocalDate;
import com.ac2.facens.utils.list.ListaSE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentModel {
    private static long count = 0;
    private long id;
    private String name;
    private LocalDate birthday;
    private ListaSE subjects;

    public StudentModel(String name, LocalDate birthday) {
        this.id += count;
        this.name = name;
        this.birthday = birthday;
        this.subjects = new ListaSE();
    }
}
