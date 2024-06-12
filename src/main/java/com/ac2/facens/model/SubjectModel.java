package com.ac2.facens.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class SubjectModel {
    private static HashMap<Long, String> subjects;
    private static long count;
    private long id;
    private String name;

    static {
        subjects = new HashMap<>();
    }

    public SubjectModel(String name) {
        this.id = ++count;
        this.name = name;
        subjects.put(this.id, this.name);
    }

    public SubjectModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Map<Long, String> getSubjects() {
        return subjects;
    }
}
