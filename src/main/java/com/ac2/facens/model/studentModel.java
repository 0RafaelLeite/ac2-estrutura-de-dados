package com.ac2.facens.model;

import java.util.Date;
import com.ac2.facens.ListaSE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class studentModel {
    private int id;
    private String name;
    private Date birthday;
    private ListaSE subjects;
}
