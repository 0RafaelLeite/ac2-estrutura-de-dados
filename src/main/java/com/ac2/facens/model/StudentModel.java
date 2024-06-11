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
    private long id;
    private String name;
    private LocalDate birthday;
    private ListaSE subjects;
}
