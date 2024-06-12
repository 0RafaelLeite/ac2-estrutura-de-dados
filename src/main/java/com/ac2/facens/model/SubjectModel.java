package com.ac2.facens.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectModel {
    private static List<SubjectModel> subjects;
    private static long count;
    private long id;
    private String name;

    public SubjectModel(String name) {
        this.id = ++count;
        this.name = name;
        subjects.add(new SubjectModel(this.id, this.name));
    }

    public SubjectModel(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
