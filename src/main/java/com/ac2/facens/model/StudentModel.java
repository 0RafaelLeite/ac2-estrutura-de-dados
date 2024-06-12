package com.ac2.facens.model;

import java.time.LocalDate;
import java.util.List;

import com.ac2.facens.utils.list.ListaSE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentModel {
    private static final int MAX_SUBJECTS = 6;
    private static long count = 0;
    private long id;
    private String name;
    private LocalDate birthday;
    private ListaSE subjects;

    public StudentModel(String name, LocalDate birthday) {
        this.id = ++count;
        this.name = name;
        this.birthday = birthday;
        this.subjects = new ListaSE();
    }

    public void setSubjects(List<SubjectModel> subjects) {
        if (subjects.size() > MAX_SUBJECTS) {
            throw new IllegalArgumentException("Um estudante não pode ter mais do que 6 disciplinas.");
        }
        for(SubjectModel subject : subjects) {
            addSubject(subject);
        }
    }

    public void addSubject(SubjectModel subject) {
        if (subjects.size() >= MAX_SUBJECTS) {
            throw new IllegalStateException("Um estudante já possui o número máximo de disciplinas permitido.");
        }
        subjects.insert(subject);
    }

    public void removeSubject(long subjectId) {
        if (!subjects.remove(subjectId)) {
            throw new IllegalArgumentException("Disciplina não encontrada.");
        }
    }
}
