package com.ac2.facens.api.services;

import com.ac2.facens.model.StudentModel;
import com.ac2.facens.utils.tree.BinaryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StudentService {
    
    @Autowired
    private BinaryTree binaryTree;

    //TODO: todos os trechos comentados precisam ser implementados corretamente, estamos com um problema porque os metodos search retornam boolean e faltam alguns métodos dentro da arvore

    public void addStudent(long id, String name, LocalDate birthday) {
        StudentModel student = new StudentModel(id, name, birthday, null);
        binaryTree.insert(student);
    }

    //public StudentModel getStudent(long id) {
        //return binaryTree.search(id);
    //}

    public void deleteStudent(long id) {
        //binaryTree.delete(id);
    }

    public void addSubject(long studentId, long subjectId) {
        //StudentModel student = binaryTree.search(studentId);
        //if (student != null) {
            //student.getSubjects().insert(subjectId);
        //}
    }

    public void removeSubject(long studentId, long subjectId) {
        //StudentModel student = binaryTree.search(studentId);
        //if (student != null) {
            //student.getSubjects().remove(subjectId);
        //}
    }
}
